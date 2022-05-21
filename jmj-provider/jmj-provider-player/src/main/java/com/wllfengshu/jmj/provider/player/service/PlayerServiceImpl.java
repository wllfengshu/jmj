package com.wllfengshu.jmj.provider.player.service;

import com.wllfengshu.jmj.provider.api.player.PlayerService;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenResponse;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginResponse;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutRequest;
import com.wllfengshu.jmj.provider.api.player.model.logout.LogoutResponse;
import com.wllfengshu.jmj.provider.api.player.model.register.RegisterRequest;
import com.wllfengshu.jmj.provider.api.player.model.register.RegisterResponse;
import com.wllfengshu.jmj.provider.player.biz.giveplayerbytoken.GivePlayerByTokenBiz;
import com.wllfengshu.jmj.provider.player.biz.login.LoginBiz;
import com.wllfengshu.jmj.provider.player.biz.logout.LogoutBiz;
import com.wllfengshu.jmj.provider.player.biz.register.RegisterBiz;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Api
@Slf4j
@RestController
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private LoginBiz loginBiz;
    @Autowired
    private LogoutBiz logoutBiz;
    @Autowired
    private RegisterBiz registerBiz;
    @Autowired
    private GivePlayerByTokenBiz givePlayerByTokenBiz;

    @Override
    public LoginResponse login(LoginRequest request) {
        return loginBiz.process(request);
    }

    @Override
    public GivePlayerByTokenResponse givePlayerByToken(GivePlayerByTokenRequest request) {
        return givePlayerByTokenBiz.process(request);
    }

    @Override
    public LogoutResponse logout(LogoutRequest request) {
        return logoutBiz.process(request);
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return registerBiz.process(request);
    }
}
