package com.wllfengshu.jmj.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @PostMapping("/gateway")
    public String gateway() {

        System.out.println("在api gateway中执行业务逻辑处理.....");

        return "exec the api gateway.";
    }
}
