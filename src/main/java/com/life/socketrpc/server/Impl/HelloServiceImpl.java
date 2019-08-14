package com.life.socketrpc.server.Impl;

import com.life.socketrpc.server.IHello;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端方法实现类
 * @author: qirp
 * @since: 2019/8/14 15:00
 **/
@Slf4j
public class HelloServiceImpl implements IHello{

    @Override
    public String sayHello(String name) {
        log.info("客户端传参{}",name);
        return "你好：" + name;
    }
}
