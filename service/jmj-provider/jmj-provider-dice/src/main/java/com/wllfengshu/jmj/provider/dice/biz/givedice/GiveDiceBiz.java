package com.wllfengshu.jmj.provider.dice.biz.givedice;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.common.entity.provider.enumeration.CommonEnum;
import com.wllfengshu.jmj.provider.api.dice.model.DicePO;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceResponse;
import com.wllfengshu.jmj.provider.dice.constant.ProviderConstant;
import com.wllfengshu.jmj.provider.dice.dao.DiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-08 18:18
 */
@Service
public class GiveDiceBiz extends AbstractInterfaceBase<GiveDiceRequest, GiveDiceResponse> {

    @Autowired
    private DiceDAO diceDAO;

    @Override
    protected String giveActionName() {
        return "giveDice";
    }

    @Override
    protected GiveDiceResponse doProcess(GiveDiceRequest request) {
        GiveDiceResponse response = new GiveDiceResponse();
        response.setBizResponseDesc(CommonEnum.SUCCESS.getDesc());
        response.setDiceNum(ProviderConstant.DICE_NUMBER);

        LambdaQueryWrapper<DicePO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DicePO::getUsername, request.getGatewayLoginInfo().getUsername());
        DicePO dice = diceDAO.selectOne(wrapper);
        response.setDicePO(dice);
        return response;
    }
}
