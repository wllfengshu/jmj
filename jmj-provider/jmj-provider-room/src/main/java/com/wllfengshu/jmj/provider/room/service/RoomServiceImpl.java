package com.wllfengshu.jmj.provider.room.service;

import com.wllfengshu.jmj.provider.api.room.RoomService;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
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

    @Override
    public GiveRoomResponse giveRoom(GiveRoomRequest request) {
        try {
            return giveRoomBiz.giveRoom(request);
        }catch (Exception e) {
            log.error("[service-error-login]", e);
            return null;
        }
    }
}