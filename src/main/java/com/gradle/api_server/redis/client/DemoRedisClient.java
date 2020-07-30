package com.gradle.api_server.redis.client;

import com.gradle.api_server.utils.SpringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

;

/**
 * Created by DIAN on 2019/9/5.
 */

public class DemoRedisClient {
    public static long timeoutMinutes = 3 * 24 * 60;

    protected static RedisTemplate template = (RedisTemplate) SpringUtils.getBean("redisTemplate");

    public static void setValueByKey(String key, Object value) {
        getTemplate().opsForValue().set(key, value);
    }

    public static Object getValueByKey(String key) {
        if (key != null && !key.isEmpty()) {
            return getTemplate().opsForValue().get(key);
        } else {
            return null;
        }
    }

    public static void setValueByKeyWithLifeCycle(String key, Object value) {
        getTemplate().opsForValue().set(key, value, timeoutMinutes, TimeUnit.MINUTES);
    }

    public static boolean existsKey(String key) {
        return getTemplate().hasKey(key);
    }

    public static boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return getTemplate().expire(key, timeout, timeUnit);
    }

    public static Set<String> keys(String pattern) {
        return getTemplate().keys(pattern);
    }

    public static RedisTemplate getTemplate() {
        return template;
    }
}
