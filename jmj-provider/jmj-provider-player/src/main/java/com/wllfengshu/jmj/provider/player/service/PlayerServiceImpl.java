package com.wllfengshu.jmj.provider.player.service;

import com.wllfengshu.jmj.provider.api.player.PlayerService;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenResponse;
import com.wllfengshu.jmj.provider.api.player.model.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.LoginResponse;
import com.wllfengshu.jmj.provider.player.biz.giveplayerbytoken.GivePlayerByTokenBiz;
import com.wllfengshu.jmj.provider.player.biz.login.LoginBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Slf4j
@RestController
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private LoginBiz loginBiz;
    @Autowired
    private GivePlayerByTokenBiz givePlayerByTokenBiz;

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            return loginBiz.login(request);
        }catch (Exception e) {
            log.error("[service-error-login]", e);
            return null;
        }
    }

    @Override
    public GivePlayerByTokenResponse givePlayerByToken(GivePlayerByTokenRequest request) {
        try {
            return givePlayerByTokenBiz.givePlayerByToken(request);
        }catch (Exception e) {
            log.error("[service-error-givePlayerByToken]", e);
            return null;
        }
    }
}
