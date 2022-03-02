package com.wllfengshu.jmj.provider.player.service.impl;

import com.wllfengshu.jmj.provider.player.model.vo.PlayerGameModel;
import com.wllfengshu.jmj.provider.player.model.vo.LoginRequest;
import com.wllfengshu.jmj.provider.player.model.vo.LoginResponse;
import com.wllfengshu.jmj.provider.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public void logout(String sessionId) {

    }

    @Override
    public PlayerGameModel givePlayer() {
        return null;
    }
}
