package com.life.hits.test;

import com.qirp.spring_boot_starter_hello.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试starter
 * @author: qirp
 * @since: 2019/7/2 14:11
 **/
@Slf4j
public class TestStarter {

    @Autowired
    HelloService helloService;

    @Before
    public void before(){

    }

    @Test
    public  void starterTest(){
        log.info(helloService.sayHello());
    }
}
