package com.wllfengshu.jmj.provider.player.web;

import com.wllfengshu.jmj.provider.api.player.PlayerService;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenRequest;
import com.wllfengshu.jmj.provider.api.player.model.GivePlayerByTokenResponse;
import com.wllfengshu.jmj.provider.api.player.model.LoginRequest;
import com.wllfengshu.jmj.provider.api.player.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玩家
 *
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping(value = "/login")
    public LoginResponse login(LoginRequest request) {
        return playerService.login(request);
    }

    @PostMapping(value = "/givePlayerByToken")
    public GivePlayerByTokenResponse givePlayerByToken(GivePlayerByTokenRequest request) {
        return playerService.givePlayerByToken(request);
    }

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
