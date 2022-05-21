package com.wllfengshu.jmj.provider.room.biz.giveroom;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.room.model.RoomPO;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomRequest;
import com.wllfengshu.jmj.provider.api.room.model.giveroom.GiveRoomResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-09 21:35
 */
@Service
public class GiveRoomBiz extends AbstractInterfaceBase<GiveRoomRequest, GiveRoomResponse> {

    @Override
    protected String giveActionName() {
        return "giveRoom";
    }

    @Override
    protected GiveRoomResponse doProcess(GiveRoomRequest request) {
        GiveRoomResponse response = new GiveRoomResponse();

        RoomPO roomPO = new RoomPO();
        roomPO.setTableImgUrl("https://gitee.com/tiandixuanwuliang/jmj/raw/master/center-img/room/default/room-table.png");
        response.setRoomPO(roomPO);

        return response;
    }
}
