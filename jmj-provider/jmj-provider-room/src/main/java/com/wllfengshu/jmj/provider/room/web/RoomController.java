package com.wllfengshu.jmj.provider.room.web;

import com.wllfengshu.jmj.provider.room.model.vo.CreateRoomResponse;
import com.wllfengshu.jmj.provider.room.model.vo.RoomModel;
import com.wllfengshu.jmj.provider.room.service.RoomService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房间
 *
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@RestController
@RequestMapping("/room/")
@RequiredArgsConstructor
public class RoomController {

    @NonNull
    private RoomService roomService;

    @PostMapping(value = "/giveRoom")
    public ResponseEntity<RoomModel> giveRoom(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(roomService.giveRoom(username), HttpStatus.OK);
    }

    @PostMapping(value = "/createRoom")
    public ResponseEntity<CreateRoomResponse> createRoom(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(roomService.createRoom(username), HttpStatus.OK);
    }
}
