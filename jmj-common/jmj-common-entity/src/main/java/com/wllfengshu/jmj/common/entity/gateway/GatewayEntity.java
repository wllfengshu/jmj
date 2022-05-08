package com.wllfengshu.jmj.common.entity.gateway;

import lombok.Data;

/**
 * 网关请求头
 *
 * @author wangll
 * @date 2022-05-06 9:23
 */
@Data
public class GatewayEntity {

    /**
     * 请求唯一标识
     */
    private String requestId;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 用户登陆信息
     */
    private GatewayLoginInfo gatewayLoginInfo;
}
