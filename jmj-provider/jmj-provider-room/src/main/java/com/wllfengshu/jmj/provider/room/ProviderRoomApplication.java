package com.wllfengshu.jmj.provider.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The class Paas cloud mdc application.
 *
 * @author paascloud.net@gmail.com
 */
@EnableCaching
@SpringBootApplication
public class ProviderRoomApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProviderRoomApplication.class, args);
	}
}
