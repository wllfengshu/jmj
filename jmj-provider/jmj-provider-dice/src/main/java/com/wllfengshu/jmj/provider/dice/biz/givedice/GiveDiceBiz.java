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
        response.setTextureGifUrl("我是provider-dice");
        return response;
    }
}
