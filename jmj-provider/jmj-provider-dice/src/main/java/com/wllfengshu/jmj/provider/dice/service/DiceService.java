package com.wllfengshu.jmj.provider.dice.service;

import com.wllfengshu.jmj.provider.dice.model.vo.DiceCupModel;
import com.wllfengshu.jmj.provider.dice.model.vo.DiceModel;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
public interface DiceService {

    DiceModel giveDice(String username);

    DiceCupModel doDice(String username, Integer diceNum);
}
