package com.wllfengshu.jmj.gateway.controller;

import com.wllfengshu.jmj.gateway.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExceptionController implements ErrorController {

    @Value("${pageErrorMsg:Service exception, <a href='http://localhost:8080'>Please click</a>}")
    private String pageErrorMsg;

    @Override
    public String getErrorPath() {
        // 出异常后进入该方法，交由下面的方法处理
        return "/error";
    }

    @RequestMapping("/error")
    public String error() {
        log.info("Found error, token = {}", TokenUtil.giveToken());
        return pageErrorMsg;
    }
}