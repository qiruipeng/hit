package com.life.hits.test;

/**
 * 死锁demon
 * @author: qirp
 * @since: 2019/7/29 15:41
 **/
public class DeadLock {
    public static String A = "A";
    public static String B = "B";
    public static void main(String[] args) {
        new DeadLock().deadlock();
    }

    private void deadlock(){
        //启动一个线程
        new Thread(() -> {
            synchronized (A){
                //当前线程等待2000
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(1);
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B){
                synchronized (A){
                    System.out.println(2);
                }
            }
        }).start();
    }
}
