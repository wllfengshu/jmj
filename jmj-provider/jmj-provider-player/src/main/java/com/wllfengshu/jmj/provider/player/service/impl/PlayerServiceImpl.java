package com.wllfengshu.jmj.provider.player.service.impl;

import com.wllfengshu.jmj.common.entity.player.PlayerEntity;
import com.wllfengshu.jmj.provider.api.player.PlayerService;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenResponse;
import com.wllfengshu.jmj.provider.api.player.model.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.setToken(UUID.randomUUID().toString());

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(1L);
        playerEntity.setUsername("zhangSan");
        response.setPlayerEntity(playerEntity);

        return response;
    }

    @Override
    public GivePlayerByTokenResponse givePlayerByToken(GivePlayerByTokenRequest request) {
        GivePlayerByTokenResponse response = new GivePlayerByTokenResponse();
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(1L);
        playerEntity.setUsername("zhangSan");
        response.setPlayerEntity(playerEntity);

        return response;
    }

}
