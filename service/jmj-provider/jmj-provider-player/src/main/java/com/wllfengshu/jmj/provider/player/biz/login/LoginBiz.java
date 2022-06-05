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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.wllfengshu.jmj.provider.player.constant.ProviderConstant.REDIS_PREFIX_TOKEN_TO_PLAYER;
import static com.wllfengshu.jmj.provider.player.constant.ProviderConstant.REDIS_PREFIX_USERNAME_TO_TOKEN;

/**
 * @author wangll
 * @date 2022-05-08 19:11
 */
@Service
public class LoginBiz extends AbstractInterfaceBase<LoginRequest, LoginResponse> {

    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected String giveActionName() {
        return "login";
    }

    @Override
    protected boolean checkRequest(LoginRequest request) {
        return null != request
                && StringUtils.isNotEmpty(request.getUsername())
                && StringUtils.isNotEmpty(request.getPassword());
    }

    @Override
    protected LoginResponse doProcess(LoginRequest request) {
        // 0检查是否已经登陆了
        String oldToken = (String) redisTemplate.opsForValue().get(REDIS_PREFIX_USERNAME_TO_TOKEN + request.getUsername());
        if (StringUtils.isNotEmpty(oldToken)) {
            PlayerPO po = (PlayerPO) redisTemplate.opsForValue().get(REDIS_PREFIX_TOKEN_TO_PLAYER + oldToken);
            LoginResponse response = new LoginResponse();
            response.setBizResponseCode(CommonEnum.SUCCESS.getCode());
            response.setToken(oldToken);
            response.setPlayerPO(po);
            redisTemplate.expire(REDIS_PREFIX_TOKEN_TO_PLAYER + oldToken, ProviderConstant.REGISTER_TOKEN_TIMEOUT, TimeUnit.DAYS);
            redisTemplate.expire(REDIS_PREFIX_USERNAME_TO_TOKEN + request.getUsername(), ProviderConstant.REGISTER_TOKEN_TIMEOUT, TimeUnit.DAYS);
            return response;
        }

        // 1检查用户名和密码是否匹配
        LambdaQueryWrapper<PlayerPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlayerPO::getUsername, request.getUsername());
        wrapper.eq(PlayerPO::getPassword, request.getPassword());
        PlayerPO po = playerDAO.selectOne(wrapper);
        if (null == po) {
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
        response.setPlayerPO(po);
        // 3缓存
        redisTemplate.opsForValue().set(REDIS_PREFIX_TOKEN_TO_PLAYER + token, po, ProviderConstant.REGISTER_TOKEN_TIMEOUT, TimeUnit.DAYS);
        redisTemplate.opsForValue().set(REDIS_PREFIX_USERNAME_TO_TOKEN + po.getUsername(), token, ProviderConstant.REGISTER_TOKEN_TIMEOUT, TimeUnit.DAYS);
        return response;
    }
}
