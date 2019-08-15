package com.life.proxy.dynProxy.cglib;

import com.life.proxy.dynProxy.Target;
import org.springframework.cglib.proxy.Enhancer;

/**
 *  代理工厂类
 * @author: qirp
 * @since: 2019/8/5 15:52
 **/
public class ProxyFactory {

    static Target getInstance(CglibProxy proxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setInterfaces(new Class[]{Target.class});
        enhancer.setCallback(proxy);
        Target target = (Target)enhancer.create();
        return target;
    }
}
