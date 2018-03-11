package com.edu.ldu.core.common.cache;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 唐全成
 */
public class BeanUtil {
    private static RedisTemplate<Object, Object> redisTemplate;

    public static RedisTemplate<Object, Object> getTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
