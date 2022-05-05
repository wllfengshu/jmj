package com.wllfengshu.jmj.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
