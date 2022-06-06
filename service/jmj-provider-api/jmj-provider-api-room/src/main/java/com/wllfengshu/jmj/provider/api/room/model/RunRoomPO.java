package com.wllfengshu.jmj.provider.api.room.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 房间-运行时数据库（动态）
 *
 * @author wangll
 * @date 2022-06-05 17:52
 */
@Data
@TableName("tb_run_room")
public class RunRoomPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer roomId;

    /**
     * 房间密码
     */
    private String roomPassword;

    /**
     * 玩家数量
     */
    private Integer playerNum;

    /**
     * 玩家集合
     */
    private String[] playerUsernames;
}
