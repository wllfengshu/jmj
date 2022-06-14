package com.wllfengshu.jmj.provider.api.room.model.createroom;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-06-05 9:30
 */
@Data
public class CreateRoomResponse extends GatewayResponse {

    /**
     * 房间信息
     */
    private RunRoomBO runRoomBO;
}
