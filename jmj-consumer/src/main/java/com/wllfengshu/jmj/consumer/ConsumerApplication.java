package com.wllfengshu.jmj.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author wangll
 * @date 2022-05-04 12:44
 */
@EnableFeignClients(basePackages = "com.wllfengshu.jmj.provider.api")
@SpringCloudApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
