package com;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;

/**
 * MyRedis单例类
 */
public class MyJedis {
    private static Jedis myJedis;

    public static Jedis getInstance() {
        //如果是空则进行初始化
        if (myJedis == null) {
            //由于synchronized同步是在条件判断内，所以同步
            //并不会一直都执行，增加了效率
            synchronized (MyJedis.class) {
                if (myJedis == null) {
                    //设置密码
                    DefaultJedisClientConfig.Builder builder = DefaultJedisClientConfig.builder()
                            .password("hello.lwm");
                    DefaultJedisClientConfig config = builder.build();

                    Jedis jedis = new redis.clients.jedis.Jedis("192.168.200.200", 6379, config);

                    return jedis;
                }
            }

        }
        return myJedis;
    }
}
