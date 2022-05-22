package com.wllfengshu.jmj.provider.player.biz.login;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.util.CustomStringUtils;
import com.wllfengshu.jmj.provider.api.player.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginResponse;
import com.wllfengshu.jmj.provider.player.dao.PlayerDAO;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author wangll
 * @date 2022-05-08 19:11
 */
@Service
public class LoginBiz extends AbstractInterfaceBase<LoginRequest, LoginResponse> {

    @Autowired
    private PlayerDAO playerDAO;

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
        List<PlayerPO> players = playerDAO.selectList(wrapper);
        if (CollectionUtils.isEmpty(players)) {
            LoginResponse response = new LoginResponse();
            response.setBizResponseCode(CommonEnum.USER_NAME_AND_PASSWORD_NOT_MATCH.getCode());
            response.setBizResponseDesc(CommonEnum.USER_NAME_AND_PASSWORD_NOT_MATCH.getDesc());
            return response;
        }
        // 2多于1条，说明数据库有脏数据
        if (players.size() != NumberUtils.INTEGER_ONE) {
            LoginResponse response = new LoginResponse();
            response.setBizResponseCode(CommonEnum.FOUND_USER_NUMBER_MORE_ONE.getCode());
            response.setBizResponseDesc(CommonEnum.FOUND_USER_NUMBER_MORE_ONE.getDesc());
            return response;
        }
        // 3success
        LoginResponse response = new LoginResponse();
        response.setToken(CustomStringUtils.giveUuid());
        response.setPlayerPO(players.get(NumberUtils.INTEGER_ZERO));
        return response;
    }
}
