package com.life.proxy.dynProxy.jdk;

import com.life.proxy.dynProxy.Target;
import com.life.proxy.dynProxy.TargetImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java自带代理类
 * @author: qirp
 * @since: 2019/8/5 15:21
 **/
public class JavaProxyTest {
    public static void main(String[] args) {

        Target target = new TargetImpl();
        myInvocationHandler handler = new myInvocationHandler(target);

        Target proxyTarget = (Target)Proxy.newProxyInstance(TargetImpl.class.getClassLoader(),TargetImpl.class.getInterfaces(),handler);

        proxyTarget.sing();
        proxyTarget.dance();

    }

    @Slf4j
    static class myInvocationHandler implements InvocationHandler{

        //需要被代理的类
        private Object target;

        public myInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("已经付过钱了");
            return method.invoke(target,args);
        }
    }
}
