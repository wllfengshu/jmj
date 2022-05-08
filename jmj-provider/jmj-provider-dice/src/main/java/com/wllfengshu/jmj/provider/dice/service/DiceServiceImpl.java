package com.wllfengshu.jmj.provider.dice.service;

import com.wllfengshu.jmj.provider.api.dice.DiceService;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceResponse;
import com.wllfengshu.jmj.provider.dice.biz.dodice.DoDiceBiz;
import com.wllfengshu.jmj.provider.dice.biz.givedice.GiveDiceBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:04
 */
@Slf4j
@RestController
public class DiceServiceImpl implements DiceService {

    @Autowired
    private GiveDiceBiz giveDiceBiz;
    @Autowired
    private DoDiceBiz doDiceBiz;

    @Override
    public GiveDiceResponse giveDice(GiveDiceRequest request) {
        try {
            return giveDiceBiz.giveDice(request);
        }catch (Exception e) {
            log.error("[service-error-giveDice]", e);
            return null;
        }
    }

    @Override
    public DoDiceResponse doDice(DoDiceRequest request) {
        try {
            return doDiceBiz.doDice(request);
        }catch (Exception e) {
            log.error("[service-error-doDice]", e);
            return null;
        }
    }
}
