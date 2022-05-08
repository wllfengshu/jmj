package com.wllfengshu.jmj.provider.api.dice;

import com.wllfengshu.jmj.provider.api.dice.model.DoDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.DoDiceResponse;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangll
 * @date 2022-05-04 21:02
 */
@FeignClient(name = "jmj-provider-dice")
public interface DiceService {

    @PostMapping(value = "/giveDice")
    GiveDiceResponse giveDice(@RequestBody GiveDiceRequest request);

    @PostMapping(value = "/doDice")
    DoDiceResponse doDice(@RequestBody DoDiceRequest request);
}
