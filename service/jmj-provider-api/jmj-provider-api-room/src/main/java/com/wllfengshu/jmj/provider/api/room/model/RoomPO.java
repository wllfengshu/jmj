package com.wllfengshu.jmj.provider.api.room.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangll
 * @date 2022-02-13 23:51
 */
@Data
@TableName("tb_room")
public class RoomPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer id;

    /**
     * 桌子图片地址
     */
    private String tableImgUrl;

    /**
     * 用户名
     */
    private String username;
}
