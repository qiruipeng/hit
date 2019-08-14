package com.life.myspring.factory.impl;

import com.life.myspring.factory.BeanFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * 默认bean工厂实现
 * @author: qirp
 * @since: 2019/7/5 11:55
 **/
public class DefaultBeanFactory implements BeanFactory,Closeable{

    /**
     * 实现Closeable，实现对bean的销毁
     * @throws IOException
     */
    @Override
    public void close() throws IOException {

    }

    /**
     * 通过beanName，从工厂获取bean实例
     * @param beanName
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String beanName) throws Exception {
        return null;
    }
}
