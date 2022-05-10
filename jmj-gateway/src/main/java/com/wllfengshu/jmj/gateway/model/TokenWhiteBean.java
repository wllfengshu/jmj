package com.wllfengshu.jmj.gateway.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangll
 * @date 2022-05-10 23:40
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "interceptorconfig.path")
public class TokenWhiteBean {
}
