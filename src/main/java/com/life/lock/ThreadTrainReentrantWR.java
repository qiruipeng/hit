package com.life.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 再上一个版本上加入两个窗口查询，一次出售后，前后两次查询的结果一致，不对
 * 出售和查询加读写锁
 * @author: qirp
 * @since: 2019/9/10 11:28
 **/
public class ThreadTrainReentrantWR implements Runnable {
    //共享区域
    private int trainCount = 10;

    ReadWriteLock rwlock = new ReentrantReadWriteLock();

    @Override
    public void run() {
        while (trainCount > 0) {
            try {
                Thread.sleep(500);
                sale();
            } catch (InterruptedException e) {
                rwlock.writeLock().unlock();
                e.printStackTrace();
            }
        }
    }

    private void sale() {
        rwlock.writeLock().lock();
        if (trainCount > 0) {
            --trainCount;
            System.out.println(Thread.currentThread().getName() + ",出售第" + (10 - trainCount) + "张票");
        }
        rwlock.writeLock().unlock();
    }

    public void get(){
        while (trainCount > 0) {
            rwlock.readLock().lock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                rwlock.readLock().unlock();
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",剩余"+trainCount+"张票");
            rwlock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ThreadTrainReentrantWR threadTrain = new ThreadTrainReentrantWR();
        Thread t1 = new Thread(threadTrain, "1窗口");
        Thread t2 = new Thread(threadTrain, "2窗口");
        new Thread(()->{
            threadTrain.get();
        },"3窗口").start();
        new Thread(()->{
            threadTrain.get();
        },"4窗口").start();
        t1.start();
        t2.start();
    }
}

