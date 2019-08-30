package com.life.dubbo.server;

import com.alibaba.dubbo.config.annotation.Service;
import com.life.dubbo.api.SayHelloIntface;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端实现
 * @author: qirp
 * @since: 2019/8/30 14:05
 **/
@Slf4j
@Service
public class SayServiceImpl implements SayHelloIntface {
    @Override
    public String sayHello(String name) {
        log.info("接收到客户端参数{}",name);
        return "你好：" + name;
    }
}
