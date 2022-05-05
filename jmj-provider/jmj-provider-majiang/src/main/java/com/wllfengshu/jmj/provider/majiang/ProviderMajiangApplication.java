package com.wllfengshu.jmj.provider.majiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class ProviderMajiangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderMajiangApplication.class, args);
	}
}
