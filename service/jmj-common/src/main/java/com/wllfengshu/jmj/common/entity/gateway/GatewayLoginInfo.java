package com.wllfengshu.jmj.common.entity.gateway;

import lombok.Data;

/**
 * 登陆信息
 * （和PlayerPO对象属性几乎一样，但是不包含敏感信息。会随着接口调用出现在各个微服务中）
 *
 * @author wangll
 * @date 2022-05-08 23:26
 */
@Data
public class GatewayLoginInfo {

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
