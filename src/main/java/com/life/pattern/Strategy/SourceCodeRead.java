package com.life.pattern.Strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.util.concurrent.CountDownLatch;

/**
 * 源码阅读-spring对类的创建过程分析
 * @author: qirp
 * @since: 2019/9/2 11:36
 **/
@Slf4j
public class SourceCodeRead {

    public void testResource(){
        //spring中的资源是什么:可以使URL、File、inputStream
        //spring资源访问的过程，接口类Resource，环境整合类ResourceLoader，策略类如URl、File、classpath等
        //spring的容器类或者整合类最终都是会继承或实现ResourceLoader类而拥有获取资源的能力
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        Resource resource = context.getResource("");
    }

    /**
     * 这个例子说明单例创建的实例，是线程不安全的
     * @throws InterruptedException
     */
    @Test
    public void testBeanCreate() throws InterruptedException {
        CountDownLatch countdown = new CountDownLatch(2);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/MyBean.xml");
        User user = (User) context.getBean("user1");
        user.setName("李四");
        Assert.assertNotNull(user);
        countdown.countDown();
        new Thread(() -> {
            User user1 = (User) context.getBean("user1");
            log.info("另起一个线程查看:{}",user1.getName());
            countdown.countDown();
        },"test-01").start();
        countdown.await();//等待线程数=2后执行后面的
    }

    @Test
    public void testBeanCreate1() throws InterruptedException {
        CountDownLatch countdown = new CountDownLatch(2);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/MyBean.xml");
        User user = (User) context.getBean("user3");
        user.setName("李四");
        Assert.assertNotNull(user);
        countdown.countDown();
        new Thread(() -> {
            User user1 = (User) context.getBean("user3");
            log.info("另起一个线程查看:{}",user1.getName());
            countdown.countDown();
        },"test-01").start();
        countdown.await();//等待线程数=2后执行后面的
    }

    @Test
    public void testBeanCreate3() throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/MyBean.xml");
        User user = (User) context.getBean("user2");
        log.info(user.getName());
    }





}
