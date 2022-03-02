package com.wllfengshu.jmj.provider.player.service;

import com.wllfengshu.jmj.provider.player.model.vo.PlayerGameModel;
import com.wllfengshu.jmj.provider.player.model.vo.LoginRequest;
import com.wllfengshu.jmj.provider.player.model.vo.LoginResponse;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
public interface PlayerService {

    LoginResponse login(LoginRequest loginRequest);

    void logout(String sessionId);

    PlayerGameModel givePlayer();
}
