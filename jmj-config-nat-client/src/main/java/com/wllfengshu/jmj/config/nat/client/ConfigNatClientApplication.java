package com.wllfengshu.jmj.config.nat.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigNatClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigNatClientApplication.class, args);
	}
}
