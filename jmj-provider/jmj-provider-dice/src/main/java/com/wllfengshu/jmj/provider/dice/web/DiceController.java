package com.wllfengshu.jmj.provider.dice.web;

import com.wllfengshu.jmj.provider.api.dice.DiceService;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DiceController {

    @Autowired
    private DiceService diceService;

    @PostMapping(value = "/giveDice")
    public GiveDiceResponse giveDice(@RequestBody GiveDiceRequest request) {
        return diceService.giveDice(request);
    }

    @PostMapping(value = "/doDice")
    public DoDiceResponse doDice(@RequestBody DoDiceRequest request) {
        return diceService.doDice(request);
    }
}
