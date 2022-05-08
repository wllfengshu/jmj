package com.wllfengshu.jmj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableZuulProxy
@SpringBootApplication
@EnableFeignClients(basePackages = "com.wllfengshu.jmj.provider.api")
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
