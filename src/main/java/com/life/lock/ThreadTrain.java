package com.life.lock;

/**1窗口,出售第1张票
 2窗口,出售第1张票
 2窗口,出售第2张票
 1窗口,出售第3张票
 2窗口,出售第4张票
 1窗口,出售第5张票
 2窗口,出售第6张票
 1窗口,出售第7张票
 2窗口,出售第8张票
 1窗口,出售第9张票
 2窗口,出售第10张票
 * @author: qirp
 * @since: 2019/9/10 11:28
 **/
public class ThreadTrain implements Runnable {
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
        if (trainCount > 0) {
            --trainCount;
            System.out.println(Thread.currentThread().getName() + ",出售第" + (10 - trainCount) + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadTrain threadTrain = new ThreadTrain();
        Thread t1 = new Thread(threadTrain, "1窗口");
        Thread t2 = new Thread(threadTrain, "2窗口");
        t1.start();
        t2.start();
    }
}

