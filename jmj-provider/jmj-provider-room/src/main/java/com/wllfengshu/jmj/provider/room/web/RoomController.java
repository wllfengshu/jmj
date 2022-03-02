package com.wllfengshu.jmj.provider.room.web;

import com.wllfengshu.jmj.provider.room.model.vo.CreateRoomResponse;
import com.wllfengshu.jmj.provider.room.model.vo.RoomModel;
import com.wllfengshu.jmj.provider.room.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@Api(value = "Room", tags = "房间")
@RestController
@RequestMapping("/room/")
@RequiredArgsConstructor
public class RoomController {

    @NonNull
    private RoomService roomService;

    @ApiOperation(value = "获取房间", httpMethod = "GET")
    @PostMapping(value = "/giveRoom")
    public ResponseEntity<RoomModel> giveRoom(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(roomService.giveRoom(username), HttpStatus.OK);
    }

    @ApiOperation(value = "创建房间", httpMethod = "POST")
    @PostMapping(value = "/createRoom")
    public ResponseEntity<CreateRoomResponse> createRoom(@RequestParam(value = "username") String username) {
        return new ResponseEntity<>(roomService.createRoom(username), HttpStatus.OK);
    }
}
