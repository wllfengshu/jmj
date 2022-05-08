package com.wllfengshu.jmj.provider.room.service;

import com.wllfengshu.jmj.provider.api.room.RoomService;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomResponse;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Slf4j
@RestController
public class RoomServiceImpl implements RoomService {

    @Override
    public GiveRoomResponse giveRoom(GiveRoomRequest request) {
        return null;
    }

    @Override
    public CreateRoomResponse createRoom(CreateRoomRequest request) {
        return null;
    }
}
