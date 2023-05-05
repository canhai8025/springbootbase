package com.aldeng;

import com.aldeng.utils.JedisPoolUtil;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class TestJedis {

    @Test
    public void testJedis(){

        //1.连接redis
//        Jedis jedis = new Jedis("192.168.203.131", 6379);
        Jedis jedis = JedisPoolUtil.getJedis();
        //2.操作redis
        jedis.set("aldo2","houcanhai4563");
        String aldo = jedis.get("aldo2");
        System.out.println("name:"+aldo);

        //3.关闭redis
        jedis.close();
    }
}
