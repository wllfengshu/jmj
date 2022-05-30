package com.wllfengshu.jmj.provider.api.dice.model.givedice;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import com.wllfengshu.jmj.provider.api.dice.model.DicePO;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-04 21:22
 */
@Data
public class GiveDiceResponse extends GatewayResponse {

    /**
     * 骰子数量
     */
    private Integer diceNum;

    /**
     * 骰子
     */
    private DicePO dicePO;
}