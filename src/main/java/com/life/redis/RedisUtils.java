package com.life.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * @author: qirp
 * @since: 2019/11/19 17:17
 **/
public class RedisUtils {
    private static RedisTemplate redisTemplate;

    private static DefaultRedisScript<String> redisScript;

    private static RedisSerializer<String> argsSerializer;

    private static RedisSerializer resultSerializer;

    private static final Long EXEC_RESULT = 1L;

    @PostConstruct
    public void init() {
        redisScript = new DefaultRedisScript<String>();
        redisScript.setResultType(String.class);
        argsSerializer = new StringRedisSerializer();
        resultSerializer = new StringRedisSerializer();
    }

    @Autowired
    public RedisUtils(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    /**
     * 加锁
     * @param key
     * @param requestId
     * @param expireTime
     * @return
     */
    public static boolean getLock(String key, String requestId, String expireTime) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("getLock.lua")));
        Object result = redisTemplate.execute(redisScript,argsSerializer,resultSerializer, Collections.singletonList(key),requestId,expireTime);
        if(EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param requestId
     * @return
     */
    public static boolean releaseLock(String key, String requestId) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("releaseLock.lua")));
        Object result = redisTemplate.execute(redisScript,argsSerializer,resultSerializer,Collections.singletonList(key),requestId);
        if(EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;
    }

}
