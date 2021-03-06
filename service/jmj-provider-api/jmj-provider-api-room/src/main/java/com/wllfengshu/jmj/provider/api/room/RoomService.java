package com.wllfengshu.jmj.provider.api.room;

import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.createroom.CreateRoomResponse;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
import com.wllfengshu.jmj.provider.api.room.model.joinroom.JoinRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.joinroom.JoinRoomResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@FeignClient(name = "jmj-provider-room")
public interface RoomService {

    @ApiOperation("获取房间")
    @PostMapping(value = "/giveRoom")
    GiveRoomResponse giveRoom(@RequestBody GiveRoomRequest request);

    @ApiOperation("创建房间")
    @PostMapping(value = "/createRoom")
    CreateRoomResponse createRoom(@RequestBody CreateRoomRequest request);

    @ApiOperation("加入房间")
    @PostMapping(value = "/joinRoom")
    JoinRoomResponse joinRoom(@RequestBody JoinRoomRequest request);
}
