package com.wllfengshu.jmj.provider.api.hall.model;

import lombok.Data;

/**
 * @author wangll
 * @date 2022-02-13 23:47
 */
@Data
public class HallEntity {

    /**
     * ID
     */
    private Integer id;

    /**
     * 背景图
     */
    private String bgImgUrl;

    /**
     * 用户名
     */
    private String username;
}
