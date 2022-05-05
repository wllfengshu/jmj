package com.wllfengshu.jmj.provider.dice.web;

import com.wllfengshu.jmj.provider.api.dice.DiceService;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@Api(value = "Dice", tags = "骰子")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DiceController {

    @NonNull
    private DiceService diceService;

    @ApiOperation(value = "获取骰子", httpMethod = "POST")
    @PostMapping(value = "/giveDice")
    public GiveDiceResponse giveDice(GiveDiceRequest request) {
        return diceService.giveDice(request);
    }

    @ApiOperation(value = "掷骰子", httpMethod = "POST")
    @PostMapping(value = "/doDice")
    public DoDiceResponse doDice(DoDiceRequest request) {
        return diceService.doDice(request);
    }
}
