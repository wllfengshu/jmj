package com.wllfengshu.jmj.provider.dice;

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
public class ProviderDiceApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ProviderDiceApplication.class, args);
    }
}
