package com.wllfengshu.jmj.provider.player.biz.login;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import com.wllfengshu.jmj.provider.api.player.model.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wangll
 * @date 2022-05-08 19:11
 */
@Service
public class LoginBiz {

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setToken(UUID.randomUUID().toString());

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(1L);
        playerEntity.setUsername("zhangSan");
        response.setPlayerEntity(playerEntity);

        return response;
    }
}
