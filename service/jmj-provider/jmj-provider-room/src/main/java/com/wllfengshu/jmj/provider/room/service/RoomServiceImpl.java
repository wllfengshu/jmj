package com.wllfengshu.jmj.provider.room.service;

import com.wllfengshu.jmj.provider.api.room.RoomService;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomResponse;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
import com.wllfengshu.jmj.provider.room.biz.createroom.CreateRoomBiz;
import com.wllfengshu.jmj.provider.room.biz.giveroom.GiveRoomBiz;
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
public class RoomServiceImpl implements RoomService {

    @Autowired
    private GiveRoomBiz giveRoomBiz;
    @Autowired
    private CreateRoomBiz createRoomBiz;

    @Override
    public GiveRoomResponse giveRoom(GiveRoomRequest request) {
        return giveRoomBiz.process(request);
    }

    @Override
    public CreateRoomResponse createRoom(CreateRoomRequest request) {
        return createRoomBiz.process(request);
    }
}
