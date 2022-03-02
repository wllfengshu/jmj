package com.wllfengshu.jmj.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The class Paas cloud discovery application.
 *
 * @author paascloud.net@gmail.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JmjConfigApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(JmjConfigApplication.class, args);
	}
}
