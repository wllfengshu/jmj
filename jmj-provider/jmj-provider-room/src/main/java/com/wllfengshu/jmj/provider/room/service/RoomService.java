package com.wllfengshu.jmj.provider.room.service;

import com.wllfengshu.jmj.provider.room.model.vo.CreateRoomResponse;
import com.wllfengshu.jmj.provider.room.model.vo.RoomModel;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
public interface RoomService {

    RoomModel giveRoom(String username);

    CreateRoomResponse createRoom(String username);
}
