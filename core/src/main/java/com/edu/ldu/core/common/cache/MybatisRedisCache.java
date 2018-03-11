package com.edu.ldu.core.common.cache;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Redis缓存的实现方式
 *
 * @author 唐全成
 */
public class MybatisRedisCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Long ClearInterval;
    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        try {
            CacheNamespace annotation = Class.forName(id).getAnnotation(CacheNamespace.class);
            ClearInterval = annotation.flushInterval();
        } catch (ClassNotFoundException e) {
            logger.error("MybatisRedisCache实例创建出现错误", e);
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        ValueOperations<Object, Object> vo = BeanUtil.getTemplate().opsForValue();
        vo.set(key, value, ClearInterval, TimeUnit.MILLISECONDS);
    }

    @Override
    public Object getObject(Object o) {
        ValueOperations<Object, Object> vo = BeanUtil.getTemplate().opsForValue();
        return vo.get(o);
    }

    @Override
    public Object removeObject(final Object key) {
        if (key == null) {
            return null;
        }
        return BeanUtil.getTemplate().expire(key, 0, TimeUnit.MILLISECONDS);
    }

    @Override
    public void clear() {
    }

    @Override
    public int getSize() {
        BeanUtil.getTemplate().execute((RedisConnection redisConnection) -> redisConnection.dbSize());
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}

