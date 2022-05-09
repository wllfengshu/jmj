package com.wllfengshu.jmj.provider.dice.biz.givedice;

import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceResponse;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-05-08 18:18
 */
@Service
public class GiveDiceBiz {

    public GiveDiceResponse giveDice(GiveDiceRequest request) {
        GiveDiceResponse response = new GiveDiceResponse();
        response.setDiceNum(2);
        response.setTexturePoint1Url("https://gitee.com/tiandixuanwuliang/test/raw/master/img-center/dice/default/dice-p-1.PNG");
        response.setTextureGifUrl("https://gitee.com/tiandixuanwuliang/test/raw/master/img-center/dice/default/dice-gif-1.jpg");
        return response;
    }
}
