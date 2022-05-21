package com.wllfengshu.jmj.provider.dice.service;

import com.wllfengshu.jmj.provider.api.dice.DiceService;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceResponse;
import com.wllfengshu.jmj.provider.dice.biz.dodice.DoDiceBiz;
import com.wllfengshu.jmj.provider.dice.biz.givedice.GiveDiceBiz;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Api
@Slf4j
@RestController
public class DiceServiceImpl implements DiceService {

    @Autowired
    private GiveDiceBiz giveDiceBiz;
    @Autowired
    private DoDiceBiz doDiceBiz;

    @Override
    public GiveDiceResponse giveDice(GiveDiceRequest request) {
        return giveDiceBiz.process(request);
    }

    @Override
    public DoDiceResponse doDice(DoDiceRequest request) {
        return doDiceBiz.process(request);
    }
}
