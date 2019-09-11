package com.life.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池操作
 * @author: qirp
 * @since: 2019/9/10 15:16
 **/
public class ThreadPool {



    @Test
    public void test() {
        //创建核心线程数为5、最大线程数为10，线程活跃时间5秒的线程池
        //每个线程充当医生角色
        ExecutorService service = new ThreadPoolExecutor(5, 6,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1),new MyRejected());
        //模拟有30个病人需要处理
        for(int i=0;i<8;i++){
            int flag = i;
            service.execute(()->{
                System.out.println("病人编号:"+flag+"，正在处理");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void test1() {
        //如果阻塞队列是无界的,最大线程池无效,拒绝策略基本无效,严重时导致cpu飙升
        ExecutorService service = new ThreadPoolExecutor(5, 6,
                0L, TimeUnit.MILLISECONDS,
                new LinkedTransferQueue<Runnable>(),new MyRejected());

        for(int i=0;i<8;i++){
            int flag = i;
            service.execute(()->{
                System.out.println("病人编号:"+flag+"，正在处理");
                //todo:加下面的只能工作5个线程
                try {
                    //处理5秒
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    class MyRejected implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("当前线程池"+executor.getPoolSize()+"阻塞队列大小"+executor.getQueue().size());
            System.out.println("没有多余的医生了");
        }
    }
}
