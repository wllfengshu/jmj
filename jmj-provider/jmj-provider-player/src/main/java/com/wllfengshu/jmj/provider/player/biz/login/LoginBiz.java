package com.wllfengshu.jmj.provider.player.biz.login;

import com.wllfengshu.jmj.common.util.CustomStringUtils;
import com.wllfengshu.jmj.provider.api.player.model.PlayerEntity;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-08 19:11
 */
@Service
public class LoginBiz {

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setToken(CustomStringUtils.giveUuid());

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(1L);
        playerEntity.setUsername("zhangSan");
        playerEntity.setNickname("张三");
        playerEntity.setHeadPortraitUrl("https://gitee.com/tiandixuanwuliang/test/blob/master/img-center/player/default/headPortraitUrl.png");
        playerEntity.setGoldCoins(9999L);
        response.setPlayerEntity(playerEntity);

        return response;
    }
}
