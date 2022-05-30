package com.wllfengshu.jmj.provider.player.biz.login;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.common.util.CustomStringUtils;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginResponse;
import com.wllfengshu.jmj.provider.player.constant.ProviderConstant;
import com.wllfengshu.jmj.provider.player.dao.PlayerDAO;
import com.wllfengshu.jmj.provider.player.enumeration.ProviderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangll
 * @date 2022-05-08 19:11
 */
@Service
public class LoginBiz extends AbstractInterfaceBase<LoginRequest, LoginResponse> {

    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private RedisTemplate<String, PlayerPO> redisTemplate;

    @Override
    protected String giveActionName() {
        return "login";
    }

    @Override
    protected LoginResponse doProcess(LoginRequest request) {
        // 1检查用户名和密码是否匹配
        LambdaQueryWrapper<PlayerPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlayerPO::getUsername, request.getUsername());
        wrapper.eq(PlayerPO::getPassword, request.getPassword());
        PlayerPO player = playerDAO.selectOne(wrapper);
        if (null == player) {
            LoginResponse response = new LoginResponse();
            response.setBizResponseCode(ProviderEnum.USER_NAME_AND_PASSWORD_NOT_MATCH.getCode());
            response.setBizResponseDesc(ProviderEnum.USER_NAME_AND_PASSWORD_NOT_MATCH.getDesc());
            return response;
        }
        // 2success
        String token = CustomStringUtils.giveUuid();
        LoginResponse response = new LoginResponse();
        response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
        response.setToken(token);
        response.setPlayerPO(player);
        // 3缓存
        redisTemplate.opsForValue().set(token, player, ProviderConstant.REGISTER_TOKEN_TIMEOUT, TimeUnit.DAYS);
        return response;
    }
}
