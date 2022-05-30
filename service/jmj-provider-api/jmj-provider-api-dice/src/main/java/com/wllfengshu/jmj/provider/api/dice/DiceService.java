package com.wllfengshu.jmj.provider.api.dice;

import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.dodice.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.givedice.GiveDiceResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangll
 * @date 2022-05-04 21:02
 */
@FeignClient(name = "jmj-provider-dice")
public interface DiceService {

    /**
     * 获取骰子的初始信息
     */
    @ApiOperation("获取骰子")
    @PostMapping(value = "/giveDice")
    GiveDiceResponse giveDice(@RequestBody GiveDiceRequest request);

    /**
     * 掷骰子
     */
    @ApiOperation("掷骰子")
    @PostMapping(value = "/doDice")
    DoDiceResponse doDice(@RequestBody DoDiceRequest request);
}
