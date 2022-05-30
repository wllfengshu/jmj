package com.wllfengshu.jmj.common.config.redis;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author wangll
 * @date 2022-05-22 14:22
 */
@Configuration
public class RedisConfig {

    @Bean
    public <K, V> RedisTemplate<K, V> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<K, V> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
