package com.wllfengshu.jmj.common.entity.gateway;

import com.wllfengshu.jmj.common.entity.gateway.enumeration.ResponseStatusEnum;
import lombok.Data;

/**
 * 网关响应体
 *
 * @author wangll
 * @date 2022-05-22 1:30
 */
@Data
public class GatewayResponse {

    /**
     * 状态码
     */
    private ResponseStatusEnum responseStatusEnum;

    /**
     * 描述
     */
    private String desc;
}
