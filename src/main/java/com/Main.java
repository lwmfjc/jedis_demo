package com;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //设置密码
        DefaultJedisClientConfig.Builder builder = DefaultJedisClientConfig.builder()
                .password("hello.lwm");
        DefaultJedisClientConfig config = builder.build();

        Jedis jedis = new Jedis("192.168.200.200", 6379, config);
        //ping
        String value = jedis.ping();
        System.out.println(value);
        //返回所有key
        Set<String> keys = jedis.keys("*");
        System.out.println("key count: " +
                keys.size());
        for (String key : keys) {
            System.out.printf("key--:%s---value:%s\n", key, jedis.get(key));
        }

        System.out.println("操作list");
        //操作list
        jedis.lpush("ly-list", "java", "c++", "css");
        List<String> lrange = jedis.lrange("ly-list", 0, -1);
        for (String v : lrange) {
            System.out.println("value:" + v);
        }

        //操作set
        System.out.println("操作set");
        jedis.sadd("ly-set", "1", "3", "3",
                "5", "1");
        Set<String> smembers = jedis.smembers("ly-set");
        for (String v : smembers) {
            System.out.println("value:" + v);
        }
        //操作hash
        System.out.println("操作hash");
        jedis.hset("ly-hash", "name", "lidian");
        jedis.hset("ly-hash", "age", "30");
        jedis.hset("ly-hash", "sex", "man");
        Map<String, String> lyHash = jedis.hgetAll("ly-hash");
        for (String key : lyHash.keySet()) {
            System.out.println(key + ":" + lyHash.get(key));
        }
        System.out.println("操作zset");
        jedis.zadd("person", 100, "xiaohong");
        jedis.zadd("person", 80, "xiaoli");
        jedis.zadd("person", 90, "xiaochen");
        List<String> person = jedis.zrange("person", 0, -1);
        for (String name : person) {
            System.out.println(name);
        }
        //结束操作
        jedis.flushDB();
        jedis.close();
    }
}
