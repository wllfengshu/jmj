package com.wllfengshu.jmj.provider.api.dice.model;

import lombok.Data;

/**
 * 骰子
 *
 * @author wangll
 * @date 2022-02-13 20:26
 */
@Data
public class DiceEntity {

    /**
     * ID
     */
    private Integer id;

    /**
     * 1点的材质地址
     */
    private String texturePoint1Url;

    /**
     * 掷骰子动态图的材质地址
     */
    private String textureGifUrl;

    /**
     * 用户名
     */
    private String username;
}
