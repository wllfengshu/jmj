package com.wllfengshu.jmj.provider.api.room.model.giveroom;

import com.wllfengshu.jmj.provider.api.room.model.RoomEntity;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-08 23:46
 */
@Data
public class GiveRoomResponse {

    /**
     * 房间信息
     */
    private RoomEntity roomEntity;
}
