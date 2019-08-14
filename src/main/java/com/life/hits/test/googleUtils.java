package com.life.hits.test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * @author: qirp
 * @since: 2019/5/13 10:37
 **/
@Slf4j
public class googleUtils {

    @Test
    public void logMapTest(){
        Map<String,Integer> logMap = Maps.newHashMap();

    }

    @Test
    public void biMapTest(){
        BiMap<Integer,String> biMap = HashBiMap.create();
        biMap.put(1,"a.log");
        biMap.put(2,"b.log");
        biMap.put(3,"c.log");
        biMap.put(4,"d.log");
        // 在使用BiMap时，会要求Value的唯一性
        // java.lang.IllegalArgumentException: value already present: d.log
        //那可以选择forcePut方法,但上一个会被覆盖
//        biMap.put(5,"d.log");
        log.info("biMap的值为{}",biMap);
    }

    @Test
    public void biMapInverse(){
        BiMap<Integer,String> biMap = HashBiMap.create();
        biMap.put(1,"a.log");
        biMap.put(2,"b.log");
        biMap.put(3,"c.log");
        biMap.put(4,"d.log");
        log.info("biMap的值为{}",biMap);
        BiMap<String,Integer> InverseBiMap = biMap.inverse();
        //反转的map不是新的map对象，它实现了一种视图关联，这样你对于反转后的map的所有操作都会影响原先的map对象
        log.info("biMap反转后的值为{}",InverseBiMap );
    }

    @Test
    public void rateLimiterTest(){
        RateLimiter limiter = RateLimiter.create(1.0);
        for(;;){
            if(limiter.tryAcquire()){
                log.info("开始工作。。。");
            }else{
                log.info("没有多余的处理器，请等待。。。");
            }
        }
    }

}
