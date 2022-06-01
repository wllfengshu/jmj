package com.wllfengshu.jmj.provider.api.dice.model.dodice;

import com.wllfengshu.jmj.common.entity.gateway.GatewayResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author wangll
 * @date 2022-05-04 21:27
 */
@Data
public class DoDiceResponse extends GatewayResponse {

    @ApiModelProperty("投掷的骰子信息")
    private List<DiceModel> dices;

    @ApiModelProperty("骰子数量")
    private Integer diceNum;

    @ApiModelProperty("点数之和")
    private Integer sumPoint;

    @ApiModelProperty("最小点数")
    private Integer minPoint;

    @ApiModelProperty("最大点数")
    private Integer maxPoint;
}
