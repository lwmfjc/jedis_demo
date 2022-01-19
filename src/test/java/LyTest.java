import org.junit.Test;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;

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
    private void getCode() {

    }
}
