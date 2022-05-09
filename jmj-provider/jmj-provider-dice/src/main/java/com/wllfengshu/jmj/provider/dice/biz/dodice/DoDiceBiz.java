package com.wllfengshu.jmj.provider.dice.biz.dodice;

import com.wllfengshu.jmj.common.util.CustomArrayUtils;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DiceModel;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangll
 * @date 2022-05-08 18:22
 */
@Service
public class DoDiceBiz {

    public DoDiceResponse doDice(DoDiceRequest request) {
        Integer diceNum = request.getDiceNum();
        if (null == diceNum) {
            diceNum = 2;
        }

        // 获取diceNum个1到6的随机数
        int[] num = new int[diceNum];
        for (int i = 0; i < diceNum; i++) {
            num[i] = (int) (Math.random() * 6 + 1);
        }

        // 构造返回值
        DoDiceResponse response = new DoDiceResponse();
        response.setDiceNum(diceNum);
        response.setMaxPoint(NumberUtils.max(num));
        response.setMinPoint(NumberUtils.min(num));
        response.setSumPoint(CustomArrayUtils.sum(num));

        List<DiceModel> dices = new ArrayList<>();
        for (int n : num) {
            DiceModel model = new DiceModel();
            model.setPoint(n);
            model.setTexturePointUrl("https://gitee.com/tiandixuanwuliang/test/raw/master/img-center/dice/default/dice-p-" + n + ".PNG");
            dices.add(model);
        }
        response.setDices(dices);
        return response;
    }

}
