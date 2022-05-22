package com.wllfengshu.jmj.provider.api.player.model.register;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-21 16:45
 */
@Data
public class RegisterResponse extends GatewayResponse {

    /**
     * 业务状态码
     */
    private Integer bizResponseCode;

    /**
     * 业务响应描述
     */
    private String bizResponseDesc;

}
