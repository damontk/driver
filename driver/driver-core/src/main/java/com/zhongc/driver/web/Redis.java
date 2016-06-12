package com.zhongc.driver.web;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created by cst on 2016/4/19 0019.
 */
public class Redis {
    public static void main(String... args) {
        Jedis jedis = new Jedis("192.168.99.100", 32768);
        System.out.println(jedis.set("1", "1"));
        System.out.println(jedis.ping());
//        Transaction transaction = jedis.multi();
//        transaction.exec();
        //监控key 如果key发生变化事务执行失败..
//        jedis.watch(new String[]{"1", "2"});
        Pipeline pipeline = jedis.pipelined();
        Response<String> response = pipeline.multi();
        for (int i = 0; i < 100000; i++) {
            pipeline.set("" + i, "" + i);
        }
        Response<List<Object>> l = pipeline.exec();
        List<Object> results = pipeline.syncAndReturnAll();
    }
}
