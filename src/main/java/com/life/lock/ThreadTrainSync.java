package com.life.lock;

/**
 * 利用synchronized
 * @author: qirp
 * @since: 2019/9/10 11:28
 **/
public class ThreadTrainSync implements Runnable {
    private int trainCount = 10;

    @Override
    public void run() {
        while (trainCount > 0) {
            try {
                Thread.sleep(500);
                sale();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sale() {
        synchronized (this){
            if (trainCount > 0) {
                --trainCount;
                System.out.println(Thread.currentThread().getName() + ",出售第" + (10 - trainCount) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        ThreadTrainSync threadTrain = new ThreadTrainSync();
        Thread t1 = new Thread(threadTrain, "1窗口");
        Thread t2 = new Thread(threadTrain, "2窗口");
        t1.start();
        t2.start();
    }
}

