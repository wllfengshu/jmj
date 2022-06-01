package com.wllfengshu.jmj.provider.api.dice.model.dodice;

import com.wllfengshu.jmj.common.entity.gateway.GatewayRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-04 21:27
 */
@Data
public class DoDiceRequest extends GatewayRequest {

    @ApiModelProperty("骰子数量")
    private Integer diceNum;
}
