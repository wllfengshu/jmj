package com.wllfengshu.jmj.provider.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableCaching
@SpringBootApplication
public class ProviderRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderRoomApplication.class, args);
	}
}
