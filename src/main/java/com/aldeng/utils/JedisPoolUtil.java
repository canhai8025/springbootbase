package com.aldeng.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

@Slf4j
public class JedisPoolUtil {
    private static JedisPool jedisPool = null;
    private static String host = "";
    private static int port;
    private static int maxTotal;
    private static int maxIdle;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");

        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxIdle"));
        maxIdle = Integer.parseInt(rb.getString("redis.maxIdle"));
log.info("host:{},port:{}",host,port);
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(maxIdle);
        jpc.setMaxTotal(maxTotal);
        jedisPool = new JedisPool(jpc, host, port);
    }
    public static Jedis getJedis(){

        return jedisPool.getResource();
    }
}
