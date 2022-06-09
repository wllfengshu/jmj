package com.wllfengshu.jmj.provider.api.room.model.createroom;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wllfengshu.jmj.provider.api.player.model.PlayerPO;
import com.wllfengshu.jmj.provider.api.room.RunRoomStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
     * 当前玩家数量
     */
    private Integer currentPlayerNum;

    /**
     * 允许玩家数量
     */
    private Integer allowPlayerNum;

    /**
     * 房间状态
     */
    private RunRoomStatusEnum runRoomStatusEnum;

    /**
     * 玩家集合
     */
    @TableField(exist = false)
    private List<PlayerPO> playerPOList;
}
