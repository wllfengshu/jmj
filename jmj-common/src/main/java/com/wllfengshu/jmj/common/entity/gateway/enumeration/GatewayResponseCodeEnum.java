package com.wllfengshu.jmj.common.entity.gateway.enumeration;

/**
 * 响应的状态
 *
 * @author wangll
 * @date 2022-05-21 16:48
 */
public enum GatewayResponseCodeEnum {

    /**
     * 响应成功，请求的操作也成功
     */
    SUCCESS,

    /**
     * 响应成功，但请求的操作没有成功。例如接口抛出异常
     */
    FAIL;

}
