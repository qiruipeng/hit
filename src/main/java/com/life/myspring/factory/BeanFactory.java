package com.life.myspring.factory;

/**
 * bean工厂简单实现
 * @author: qirp
 * @since: 2019/7/5 11:54
 **/
public interface BeanFactory {
    Object getBean(String beanName) throws Exception;
}
