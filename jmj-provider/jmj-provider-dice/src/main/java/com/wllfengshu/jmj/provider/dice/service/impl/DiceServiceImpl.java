package com.wllfengshu.jmj.provider.dice.service.impl;

import com.google.common.collect.Lists;
import com.wllfengshu.jmj.provider.dice.model.vo.DiceCupModel;
import com.wllfengshu.jmj.common.entity.dice.DiceEntity;
import com.wllfengshu.jmj.provider.dice.model.vo.DiceModel;
import com.wllfengshu.jmj.provider.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {

    @Override
    public DiceModel giveDice(String username) {
        return null;
    }

    @Override
    public DiceCupModel doDice(String username, Integer diceNum) {
        DiceCupModel dice2Model = new DiceCupModel();
        DiceEntity firstDice = new DiceEntity();
        DiceEntity secondDice = new DiceEntity();

        Random random = new Random(1);
        firstDice.setPoint(random.nextInt() * 6 + 1);
        // 睡一会，防止产生的两个随机数相同的几率过高
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            log.error("doDice error", e);
        }
        secondDice.setPoint(random.nextInt() * 6 + 1);

        List<DiceEntity> dices = Lists.newArrayList();
        dices.add(firstDice);
        dices.add(secondDice);
        dice2Model.setDices(dices);
        dice2Model.setSumPoint(firstDice.getPoint() + secondDice.getPoint());
        return dice2Model;
    }

}
