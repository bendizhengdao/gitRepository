package com.ssm.util;

import java.util.List;
import java.util.Set;

import com.ssm.inter.RedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisSingleUtil implements RedisUtil {

	private JedisPool jPool;
    private JedisPoolConfig config;
    private final String host;
    private final int port;
    private final int expireTime;             //默认失效时间
    
    public RedisSingleUtil() {
        this(60 * 60, "127.0.0.1", 6379);
    }
    
    
    public RedisSingleUtil(int time, String host, int port) {
        this.expireTime = time;
        this.host = host;
        this.port = port;
    }
    
    public RedisSingleUtil(String host, int port) {
        this(60 * 60, host, port);
    }
    
    
    @Override
    public void init() {
        jPool = new JedisPool(host, port);
    }

    
    /**
     * 添加，失效时间60*60
     *
     * @param key   String
     * @param value String
     * @return String
     */
    @Override
    public String set(String key, String value) {
        return set(key, value, expireTime);
    }
    
    /**
     * 添加
     *
     * @param key   String
     * @param value String
     * @param time  int
     * @return String
     */
    @Override
    public String set(String key, String value, int time) {
        try (Jedis jedis = jPool.getResource()) {
            String result = jedis.set(key, value);
            jedis.expire(key, time);
            return result;
        }
    }
    
    /**
     * 获取
     *
     * @param key String
     * @return String
     */
    @Override
    public String get(String key) {
        try (Jedis jedis = jPool.getResource()) {
            return jedis.get(key);
        }
    }
    
    /**
     * 删除
     *
     * @param key String
     */
    @Override
    public void delete(String... key) {
        try (Jedis jedis = jPool.getResource()) {
            jedis.del(key);
        }
    }
    
    /**
     * 设置失效时间
     *
     * @param key  String
     * @param time int
     */
    @Override
    public void expire(String key, int time) {
        try (Jedis jedis = jPool.getResource()) {
            jedis.del(key);
        }
    }
    
    @Override
    public boolean exist(String key) {
        try (Jedis jedis = jPool.getResource()) {
            return jedis.exists(key);
        }
    }
    
    @Override
    public int size(String prefix) {
        try(Jedis jedis = jPool.getResource()){
            //todo 优化scan
            Set<String> keys = jedis.keys(prefix + "*");
            return keys.size();
        }
    }
    
    
    @Override
    public Jedis getJedis() {
        return jPool.getResource();
    }
    
    
    @Override
    public String blpop(int time, String... key) {
        List<String> blpop = null;
        try (Jedis jedis = jPool.getResource()) {
            blpop = jedis.blpop(time, key);
        }
        return blpop.get(1);
    }
    
    @Override
    public void rpush(String key, String... value) {
        try (Jedis jedis = jPool.getResource()) {
            jedis.rpush(key, value);
        }
    }

}
