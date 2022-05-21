package com.wllfengshu.jmj.provider.player.biz.login;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.util.CustomStringUtils;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginResponse;
import com.wllfengshu.jmj.provider.player.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        playerDAO.selectBy

        LoginResponse response = new LoginResponse();
        response.setToken(CustomStringUtils.giveUuid());

        PlayerPO playerPO = new PlayerPO();
        playerPO.setId(1L);
        playerPO.setUsername("zhangSan");
        playerPO.setNickname("张三");
        playerPO.setHeadPortraitUrl("https://gitee.com/tiandixuanwuliang/jmj/raw/master/center-img/player/default/headPortraitUrl.png");
        playerPO.setGoldCoins(9999L);
        response.setPlayerPO(playerPO);

        return response;
    }
}
