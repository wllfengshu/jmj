package com.wllfengshu.jmj.provider.dice;

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
public class ProviderDiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDiceApplication.class, args);
    }
}
