package com.gradle.api_server.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by DIAN on 2019/9/5.
 */
public class RedisDemo extends AbstrackRedisConfiguration {


    @Value("${spring.redis.host}")
    String hostName;
    @Value("${spring.redis.port}")
    Integer port;
    @Value("${spring.redis.password}")
    String password;
    @Value("${spring.redis.pool.max-idle}")
    Integer maxIdle;
    @Value("${spring.redis.database}")
    Integer index;
    @Value("${spring.redis.pool.max-active}")
    Integer maxTotal;

    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate() {
        RedisTemplate redis = new RedisTemplate();
        redis.setConnectionFactory(connectionFactory(hostName, port, password, maxIdle, maxTotal, index, -1, true));
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redis.setKeySerializer(stringSerializer);
        return redis;
    }
}
