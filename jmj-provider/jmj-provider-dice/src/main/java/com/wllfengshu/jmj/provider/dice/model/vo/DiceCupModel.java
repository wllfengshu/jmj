package com.wllfengshu.jmj.provider.dice.model.vo;

import com.wllfengshu.jmj.common.entity.dice.DiceEntity;
import lombok.Data;

import java.util.List;

/**
 * 骰盅
 *
 * @author wangll
 * @date 2022-02-13 20:28
 */
@Data
public class DiceCupModel {

    /**
     * 骰子
     */
    private List<DiceEntity> dices;

    /**
     * 骰子数量
     */
    private Integer diceNum;

    /**
     * 点数之和
     */
    private Integer sumPoint;
}
