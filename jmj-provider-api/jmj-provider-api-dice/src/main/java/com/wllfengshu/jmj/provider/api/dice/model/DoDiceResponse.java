package com.wllfengshu.jmj.provider.api.dice.model;

import com.wllfengshu.jmj.provider.api.dice.model.entity.DiceEntity;

import java.util.List;

/**
 * @author wangll
 * @date 2022-05-04 21:27
 */
public class DoDiceResponse {

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