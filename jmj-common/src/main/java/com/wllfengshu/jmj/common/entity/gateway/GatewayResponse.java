package com.wllfengshu.jmj.common.entity.gateway;

import com.wllfengshu.jmj.common.entity.gateway.enumeration.GatewayResponseCodeEnum;
import lombok.Data;

/**
 * 网关响应体
 * （所有接口响应都必须继承该类）
 *
 * @author wangll
 * @date 2022-05-22 1:30
 */
@Data
public class GatewayResponse {

    /**
     * 网关-状态码
     * （子类不要手动给该类赋值。该类由AbstractInterfaceBase中的统一流程控制赋值）
     */
    private GatewayResponseCodeEnum gatewayResponseCodeEnum;

    /**
     * 网关-响应描述
     * （子类不要手动给该类赋值。该类由AbstractInterfaceBase中的统一流程控制赋值）
     */
    private String gatewayResponseDesc;

    /**
     * 业务状态码
     */
    private Integer bizResponseCode;

    /**
     * 业务响应描述
     */
    private String bizResponseDesc;
}
