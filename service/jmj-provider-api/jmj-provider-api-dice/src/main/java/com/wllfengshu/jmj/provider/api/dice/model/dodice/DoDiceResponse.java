package com.wllfengshu.jmj.provider.api.dice.model.dodice;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import lombok.Data;

import java.util.List;

/**
 * @author wangll
 * @date 2022-05-04 21:27
 */
@Data
public class DoDiceResponse extends GatewayResponse {

    /**
     * 投掷的骰子信息
     */
    private List<DiceModel> dices;

    /**
     * 骰子数量
     */
    private Integer diceNum;

    /**
     * 点数之和
     */
    private Integer sumPoint;

    /**
     * 最小点数
     */
    private Integer minPoint;

    /**
     * 最大点数
     */
    private Integer maxPoint;
}