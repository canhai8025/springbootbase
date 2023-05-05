package com.aldeng.redis;

import com.aldeng.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class Service {
    private  String id;
    private  int num;
    public  Service(String id,int num){
        this.id = id;
        this.num = num;
    }
    //控制操作
    public void service(){
        Jedis jedis = JedisPoolUtil.getJedis();
        String value = jedis.get("compid:" + id);
        try {
            if(value == null){
                //不存在，创建该值
                jedis.setex("compid:"+id,13,Long.MAX_VALUE-num+"");
            }else{
                Long v = jedis.incr("compid:"+id);
                business(id,num-(Long.MAX_VALUE-v));
            }

        }catch (JedisDataException e){
            System.out.println(id+"使用次数达到上限，请升级会员级别。");
            return;
        }finally {
            jedis.close();
        }
    }
    //业务操作
    public void business(String id,Long v){
        System.out.println("用户："+id+" 业务操作执行第"+v+"次");
    }
}

class Main{
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("初级用户",10);
        MyThread mt2 = new MyThread("高级用户",30);
        mt1.start();
        mt2.start();
    }
}
