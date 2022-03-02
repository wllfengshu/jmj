package com.wllfengshu.jmj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The class Paas cloud gateway application.
 *
 * @author paascloud.net@gmail.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JmjGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmjGatewayApplication.class, args);
	}
}
