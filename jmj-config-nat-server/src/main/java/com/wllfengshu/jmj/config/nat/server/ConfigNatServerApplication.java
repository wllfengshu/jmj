package com.wllfengshu.jmj.config.nat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigNatServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigNatServerApplication.class, args);
	}
}
