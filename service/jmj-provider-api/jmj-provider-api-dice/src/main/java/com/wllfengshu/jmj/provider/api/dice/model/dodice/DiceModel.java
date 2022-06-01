package com.wllfengshu.jmj.provider.api.dice.model.dodice;

import com.wllfengshu.jmj.provider.api.dice.model.DicePO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wangll
 * @date 2022-05-09 12:50
 */
@Data
public class DiceModel extends DicePO {

    @ApiModelProperty("点数")
    private Integer point;

    @ApiModelProperty("对应点数的材质地址")
    private String texturePointUrl;
}
