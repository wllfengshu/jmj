package com.wllfengshu.jmj.provider.dice.service.impl;

import com.wllfengshu.jmj.provider.api.dice.DiceService;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {

    @Override
    public GiveDiceResponse giveDice(GiveDiceRequest request) {
        GiveDiceResponse response = new GiveDiceResponse();
        response.setTextureGifUrl("我是provider-dice");
        return response;
    }

    @Override
    public DoDiceResponse doDice(DoDiceRequest request) {
        return null;
    }
}
