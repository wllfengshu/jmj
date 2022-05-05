package com.wllfengshu.jmj.provider.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableCaching
@SpringBootApplication
public class ProviderPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderPlayerApplication.class, args);
	}
}
