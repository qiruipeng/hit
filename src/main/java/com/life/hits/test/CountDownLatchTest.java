package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: qirp
 * @since: 2019/8/1 11:25
 **/
@Slf4j
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            //计数器减1
            c.countDown();
            log.info("打印1");
//            c.countDown();
            log.info("打印2");
        }).start();
        //阻塞当前线程直到计数器为0
        c.await();
        log.info("打印3");
    }
}
