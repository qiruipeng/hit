package com.life.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用可重入锁
 * @author: qirp
 * @since: 2019/9/10 11:28
 **/
public class ThreadTrainReentrant implements Runnable {
    //共享区域
    private int trainCount = 10;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (trainCount > 0) {
            try {
                Thread.sleep(500);
                sale();
            } catch (InterruptedException e) {
                lock.unlock();
                e.printStackTrace();
            }
        }
    }

    private void sale() {
        lock.lock();
        if (trainCount > 0) {
            --trainCount;
            System.out.println(Thread.currentThread().getName() + ",出售第" + (10 - trainCount) + "张票");
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        ThreadTrainReentrant threadTrain = new ThreadTrainReentrant();
        Thread t1 = new Thread(threadTrain, "1窗口");
        Thread t2 = new Thread(threadTrain, "2窗口");
        t1.start();
        t2.start();
    }
}

