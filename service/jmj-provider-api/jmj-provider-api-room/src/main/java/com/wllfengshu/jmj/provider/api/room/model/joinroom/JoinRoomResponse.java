package com.wllfengshu.jmj.provider.api.room.model.joinroom;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import com.wllfengshu.jmj.provider.api.room.model.RunRoomPO;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-06-05 9:30
 */
@Data
public class JoinRoomResponse extends GatewayResponse {

    /**
     * 加入的房间状态
     */
    private JoinRoomStatusEnum joinRoomStatusEnum;
    /**
     * 房间信息
     */
    private RunRoomPO runRoomPO;
}
