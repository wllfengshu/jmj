package com.wllfengshu.jmj.common.entity.gateway;

import lombok.Data;

/**
 * 网关求头体
 * (所有接口请求都必须继承该类，除注册和登陆外)
 *
 * @author wangll
 * @date 2022-05-06 9:23
 */
@Data
public class GatewayRequest {

    /**
     * 登陆的唯一凭证
     */
    private String token;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 用户登陆信息
     */
    private GatewayLoginInfo gatewayLoginInfo;
}
