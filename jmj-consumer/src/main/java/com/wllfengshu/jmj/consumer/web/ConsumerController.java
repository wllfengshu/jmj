package com.wllfengshu.jmj.consumer.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wllfengshu.jmj.provider.api.dice.DiceService;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceRequest;
import com.wllfengshu.jmj.provider.api.dice.model.GiveDiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-02-13 20:03
 */
@Slf4j
@Api(value = "Consumer", tags = "消费者")
@RestController
@RequestMapping("/consumer/")
@RequiredArgsConstructor
public class ConsumerController {

    @Autowired
    private DiceService diceService;

    @ApiOperation(value = "测试", httpMethod = "GET")
    @GetMapping(value = "/test")
    @HystrixCommand(fallbackMethod="error", ignoreExceptions= RuntimeException.class,
            commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="5000")})
    public String test() {
        GiveDiceRequest request = new GiveDiceRequest();
        request.setUsername("aaaaaa");
        GiveDiceResponse response = diceService.giveDice(request);
        response.setTexturePoint1Url("我是消费者添加的数据");
        return response.toString();
    }

    // 发生熔断，会回调这个方法，在上面方法的fallbackMethod中指定
    public String error() {
        return "Error Error Exception";
    }
}
