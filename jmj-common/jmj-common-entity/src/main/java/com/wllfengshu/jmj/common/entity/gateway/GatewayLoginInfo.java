package com.wllfengshu.jmj.common.entity.gateway;

import lombok.Data;

/**
 * 登陆信息（和PlayerEntity对象属性几乎一样）
 *
 * @author wangll
 * @date 2022-05-08 23:26
 */
@Data
public class GatewayLoginInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 登陆名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String headPortraitUrl;

    /**
     * 金币
     */
    private Long goldCoins;
}
