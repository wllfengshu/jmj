package com.wllfengshu.jmj.config.server.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangll
 * @date 2022-05-05 22:16
 */
@RestController
public class ConfigController {

    @Value("${urlNameLiang}")
    private String url;

    @RequestMapping("/cloud/url")
    public String url () {
        return url;
    }

}
