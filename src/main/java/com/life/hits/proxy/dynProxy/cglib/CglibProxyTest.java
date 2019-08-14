package com.life.hits.proxy.dynProxy.cglib;

import com.life.hits.proxy.dynProxy.Target;

/**
 *  cglib代理类
 * @author: qirp
 * @since: 2019/8/5 15:44
 **/
public class CglibProxyTest {
    public static void main(String[] args) {
        Target target = ProxyFactory.getInstance(new CglibProxy());
        target.dance();
        target.sing();
    }

}
