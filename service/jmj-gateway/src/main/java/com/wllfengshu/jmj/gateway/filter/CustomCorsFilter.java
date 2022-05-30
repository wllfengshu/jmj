package com.wllfengshu.jmj.gateway.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author wangll
 * @date 2022-05-29 20:32
 */
@Configuration
public class CustomCorsFilter {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedMethod("POST");
        config.addAllowedHeader("*");
        config.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        //3.返回新的CORSFilter
        return new CorsFilter(configSource);
    }
}

