package com.life.hits.proxy.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: qirp
 * @since: 2019/8/5 16:40
 **/
@Slf4j
public class StaticProxy implements Target {

    private Target target;

    public StaticProxy() {
        this.target = new TargetImpl();
    }

    @Override
    public void sing() {
        log.info("已经交过钱了");
        target.sing();
    }

    @Override
    public void dance() {
        log.info("已经交过钱了");
        target.dance();
    }
}
