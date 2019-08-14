package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: qirp
 * @since: 2019/8/8 14:38
 **/
@Slf4j
public class PrintABC {

    private static Lock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    private static String currentTreadName = "A";

    public static void main(String[] args) {
        ExecutorService poolExecutor = Executors.newFixedThreadPool(3);
        poolExecutor.execute(new ThreadA());
        poolExecutor.execute(new ThreadB());
        poolExecutor.execute(new ThreadC());

        poolExecutor.shutdown();
    }

    static class ThreadA implements Runnable{
        @Override
        public void run() {
            for(int i =0;i<10;i++){
                lock.lock();
                while(currentTreadName != "A"){
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("A");
                currentTreadName = "B";
                conditionB.signal();
                lock.unlock();
            }
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run() {
            for(int i =0;i<10;i++){
                lock.lock();
                while(currentTreadName != "B"){
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("B");
                currentTreadName = "C";
                conditionC.signal();
                lock.unlock();
            }
        }
    }

    static class ThreadC implements Runnable{
        @Override
        public void run() {
            for(int i =0;i<10;i++){
                lock.lock();
                while(currentTreadName != "C"){
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("C");
                currentTreadName = "A";
                conditionA.signal();
                lock.unlock();
            }
        }
    }


}
