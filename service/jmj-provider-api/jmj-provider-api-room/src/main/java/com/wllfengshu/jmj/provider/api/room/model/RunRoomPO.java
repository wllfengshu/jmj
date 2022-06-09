package com.wllfengshu.jmj.provider.api.room.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 房间-运行时数据库（用来生成房间号）
 *
 * @author wangll
 * @date 2022-06-05 17:52
 */
@Data
@TableName("tb_run_room")
public class RunRoomPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间号
     */
    @TableId
    private Integer roomId;

    /**
     * 创建者用户名
     */
    private String creatorUsername;
}
