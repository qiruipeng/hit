package com.life.dubbo.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.life.dubbo.api.SayHelloIntface;
import org.junit.Test;

/**
 * @author: qirp
 * @since: 2019/8/30 14:08
 **/
public class ClientServer {

    @Reference
    private SayHelloIntface sayHelloIntface;

    @Test
    public void testHello(){
        String name = "黎明";
        String result = sayHelloIntface.sayHello(name);
    }
}
