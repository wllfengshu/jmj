package com.wllfengshu.jmj.provider.api.dice.model;

import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-04 21:22
 */
@Data
public class GiveDiceResponse {

    /**
     * 骰子点数图片的地址
     */
    private String texturePoint1Url;

    /**
     * 骰子动态图地址
     */
    private String textureGifUrl;
}
