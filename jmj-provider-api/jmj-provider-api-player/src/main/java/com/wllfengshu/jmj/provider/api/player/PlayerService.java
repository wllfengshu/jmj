package com.wllfengshu.jmj.provider.api.player;

import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.giveplayerbytoken.GivePlayerByTokenResponse;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.login.LoginResponse;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("登陆")
    LoginResponse login(@RequestBody LoginRequest request);

    @PostMapping(value = "/givePlayerByToken")
    @ApiOperation("通过token获取玩家信息")
    GivePlayerByTokenResponse givePlayerByToken(@RequestBody GivePlayerByTokenRequest request);

//    @PostMapping(value = "/logout")
//    public void logout(@RequestHeader(value = "sessionId") String sessionId) {
//        playerService.logout(sessionId);
//    }

//    @ApiOperation(value = "创建房间", httpMethod = "GET")
//    @GetMapping(value = "/createRoom")
//    public ResponseEntity<HallEntity> createRoom(@RequestParam(value = "username") String username) {
//        return new ResponseEntity<>(playerService.createRoom(username), HttpStatus.OK);
//    }

//    @ApiOperation(value = "真人对战", httpMethod = "GET")
//    @GetMapping(value = "/realPersonBattle")
//    public ResponseEntity<HallEntity> realPersonBattle(@RequestParam(value = "username") String username) {
//        return new ResponseEntity<>(playerService.realPersonBattle(username), HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "人机对战", httpMethod = "GET")
//    @GetMapping(value = "/manMachineBattle")
//    public ResponseEntity<HallEntity> manMachineBattle(@RequestParam(value = "username") String username) {
//        return new ResponseEntity<>(playerService.manMachineBattle(username), HttpStatus.OK);
//    }
}
