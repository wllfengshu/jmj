package com.wllfengshu.jmj.provider.dice.biz.givedice;

import com.wllfengshu.jmj.common.api.inter.AbstractInterfaceBase;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-08 18:18
 */
@Service
public class GiveDiceBiz extends AbstractInterfaceBase<GiveDiceRequest, GiveDiceResponse> {

    @Override
    protected String giveActionName() {
        return "giveDice";
    }

    @Override
    protected GiveDiceResponse doProcess(GiveDiceRequest request) {
        GiveDiceResponse response = new GiveDiceResponse();
        response.setDiceNum(2);
        response.setTexturePoint1Url("https://gitee.com/tiandixuanwuliang/jmj/raw/master/center-img/dice/default/dice-p-1.PNG");
        response.setTextureGifUrl("https://gitee.com/tiandixuanwuliang/jmj/raw/master/center-img/dice/default/dice-gif-1.jpg");
        return response;
    }
}
