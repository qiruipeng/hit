package com.life.proxy.dynProxy;

import lombok.extern.slf4j.Slf4j;

/**
 *  需要被代理类的实现
 * @author: qirp
 * @since: 2019/8/5 15:17
 **/
@Slf4j
public class TargetImpl implements Target{

    @Override
    public void sing() {
        log.info("我在唱歌");
    }

    @Override
    public void dance() {
        log.info("我在跳舞");
    }
}
