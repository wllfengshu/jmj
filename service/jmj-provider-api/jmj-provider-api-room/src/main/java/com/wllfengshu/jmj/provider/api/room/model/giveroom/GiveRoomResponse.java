package com.wllfengshu.jmj.provider.api.room.model.giveroom;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import com.wllfengshu.jmj.provider.api.room.model.RoomPO;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-08 23:46
 */
@Data
public class GiveRoomResponse extends GatewayResponse {

    /**
     * 房间信息
     */
    private RoomPO roomPO;
}
