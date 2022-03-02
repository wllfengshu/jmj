package com.wllfengshu.jmj.provider.room.service.impl;

import com.wllfengshu.jmj.provider.room.model.vo.CreateRoomResponse;
import com.wllfengshu.jmj.provider.room.model.vo.RoomModel;
import com.wllfengshu.jmj.provider.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    @Override
    public RoomModel giveRoom(String username) {
        RoomModel room = new RoomModel();
        room.setTableImgUrl("");
        return room;
    }

    @Override
    public CreateRoomResponse createRoom(String username) {
        CreateRoomResponse response = new CreateRoomResponse();
        response.setRoomId(UUID.randomUUID().toString());
        return response;
    }
}
