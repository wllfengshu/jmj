package com.wllfengshu.jmj.provider.api.dice.model;

import com.wllfengshu.jmj.common.entity.gateway.GatewayHeader;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-04 21:27
 */
@Data
public class DoDiceRequest extends GatewayHeader {

    /**
     * 骰子数量
     */
    private Integer diceNum;
}
