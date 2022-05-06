package com.wllfengshu.jmj.provider.player.web;

import com.wllfengshu.jmj.provider.player.model.vo.LoginRequest;
import com.wllfengshu.jmj.provider.player.model.vo.LoginResponse;
import com.wllfengshu.jmj.provider.player.service.PlayerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 玩家
 *
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@RestController
@RequestMapping("/player/")
@RequiredArgsConstructor
public class PlayerController {

    @NonNull
    private PlayerService playerService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(playerService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public void logout(@RequestHeader(value = "sessionId") String sessionId) {
        playerService.logout(sessionId);
    }

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
