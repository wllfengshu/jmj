package com.wllfengshu.jmj.provider.api.room.model.createroom;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 房间信息
 *
 * @author wangll
 * @date 2022-06-05 17:52
 */
@Data
public class RunRoomBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间号
     */
    private Integer roomId;

    /**
     * 创建者用户名
     */
    private String creatorUsername;

    /**
     * 房间密码
     */
    private String roomPassword;

    /**
     * 当前玩家数量
     */
    private Integer currentPlayerNum;

    /**
     * 允许最大玩家数量
     */
    private Integer allowMaxPlayerNum;

    /**
     * 房间状态
     */
    private RunRoomStatusEnum runRoomStatusEnum;

    /**
     * 玩家的token集合
     */
    private List<String> tokens;
}
