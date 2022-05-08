package com.wllfengshu.jmj.provider.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableCaching
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.wllfengshu.jmj.*")
public class ProviderPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderPlayerApplication.class, args);
	}
}
