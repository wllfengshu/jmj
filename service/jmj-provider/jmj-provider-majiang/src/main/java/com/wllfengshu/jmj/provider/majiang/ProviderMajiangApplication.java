package com.wllfengshu.jmj.provider.majiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.wllfengshu.jmj.*")
public class ProviderMajiangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderMajiangApplication.class, args);
	}
}
