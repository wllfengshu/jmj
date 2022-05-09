package com.wllfengshu.jmj.provider.room.biz.giveroom;

import com.wllfengshu.jmj.provider.api.room.model.RoomEntity;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-09 21:35
 */
@Service
public class GiveRoomBiz {

    public GiveRoomResponse giveRoom(GiveRoomRequest request) {
        GiveRoomResponse response = new GiveRoomResponse();

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setTableImgUrl("https://gitee.com/tiandixuanwuliang/test/blob/master/img-center/room/default/room-table.png");
        response.setRoomEntity(roomEntity);

        return response;
    }
}
