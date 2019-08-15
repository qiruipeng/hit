package com.life.proxy.staticProxy;

/**
 * 静态代理
 * @author: qirp
 * @since: 2019/8/5 16:39
 **/
public class StaticProxyTest {
    public static void main(String[] args) {
        Target target = new StaticProxy();

        target.sing();
        target.dance();
    }
}
