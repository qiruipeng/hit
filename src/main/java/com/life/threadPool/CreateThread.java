package com.life.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 创建
 * @author: qirp
 * @since: 2019/9/11 11:01
 **/
@Slf4j
public class CreateThread {

    @Test
    public void test01(){
        new MyThread().run();
        new MyThread1().run();
        new MyThread1().start();
        new Thread(() ->{
            log.info("这是另一种，通过start方式创建的");
        }).start();
    }

    //方式一
    class MyThread implements Runnable{
        @Override
        public void run() {
            log.info("通过实现runnable实现");
        }
    }

    //方式二
    class MyThread1 extends Thread{
        public void run(){
            log.info("这是重写的方式，线程已经启动");
        }
    }
}
