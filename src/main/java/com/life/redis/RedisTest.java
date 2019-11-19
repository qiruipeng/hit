package com.life.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * 测试redis
 * @author: qirp
 * @since: 2019/11/6 16:26
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
@ActiveProfiles("dev")
@TestPropertySource(locations = "classpath:application.properties")
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedisObj() {
        try {
            redisTemplate.opsForValue().set("pay:key", "value",100, TimeUnit.SECONDS);
        } catch (Exception e) {
            //不做任何处理
        }
        System.out.println("继续执行");
    }

}
