import org.junit.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;

import java.util.Random;

public class LyTest {
    private Jedis getRedis() {
        //设置密码
        DefaultJedisClientConfig.Builder builder = DefaultJedisClientConfig.builder()
                .password("hello.lwm");
        DefaultJedisClientConfig config = builder.build();

        Jedis jedis = new Jedis("192.168.200.200", 6379, config);
        return jedis;
    }

    @Test
    public String getCode() {
        int i = new Random().nextInt(10000);
        StringBuilder builder=new StringBuilder();
        if(i<10){
            return "000"+i;
        }else if(i<100){
            return "00"+i;
        }
        System.out.println(i);
        return builder.toString();
    }
}
