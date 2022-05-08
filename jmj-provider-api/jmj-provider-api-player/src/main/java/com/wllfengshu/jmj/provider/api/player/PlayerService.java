package com.wllfengshu.jmj.provider.api.player;


import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenResponse;
import com.wllfengshu.jmj.provider.api.player.model.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@FeignClient(name = "jmj-provider-player")
public interface PlayerService {

    @PostMapping(value = "/login")
    LoginResponse login(@RequestBody LoginRequest request);

    @PostMapping(value = "/givePlayerByToken")
    GivePlayerByTokenResponse givePlayerByToken(@RequestBody GivePlayerByTokenRequest request);
}
