package com.life.hits.proxy.dynProxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: qirp
 * @since: 2019/8/5 15:51
 **/
@Slf4j
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        log.info("已经交过钱了");
        //触发目标类
        methodProxy.invokeSuper(o,objects);

        return null;
    }
}
