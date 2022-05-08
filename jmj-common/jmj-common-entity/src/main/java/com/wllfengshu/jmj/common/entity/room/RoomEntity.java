package com.wllfengshu.jmj.common.entity.room;

import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-13 23:51
 */
@Data
public class RoomEntity {

    /**
     * ID
     */
    private Integer id;

    /**
     * 桌子图片地址
     */
    private String tableImgUrl;

    /**
     * 用户名
     */
    private String username;

    /**
     * 正在被使用
     */
    private Byte inUse;
}
