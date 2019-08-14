package com.life.myspring.beandefinition.impl;

import com.life.myspring.beandefinition.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 默认bean定义类
 * @author: qirp
 * @since: 2019/7/5 13:37
 **/
public class DefaultBeanDefinition implements BeanDefinition {
    @Override
    public Class<?> getBeanClass() {
        return null;
    }

    @Override
    public String getBeanName() {
        return null;
    }

    @Override
    public String getBeanFactory() {
        return null;
    }

    @Override
    public String getCreateBeanMethod() {
        return null;
    }

    @Override
    public String getStaticCreateBeanMethod() {
        return null;
    }

    @Override
    public String getBeanInitMethodName() {
        return null;
    }

    @Override
    public String getBeanDestoryMethodName() {
        return null;
    }

    @Override
    public String getScope() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public boolean isPrototype() {
        return false;
    }

    @Override
    public List<?> getConstructorArg() {
        return null;
    }

    @Override
    public Constructor<?> getConstructor() {
        return null;
    }

    @Override
    public void setConstructor(Constructor<?> constructor) {

    }

    @Override
    public Method getFactoryMethod() {
        return null;
    }

    @Override
    public void setFactoryMethod(Method factoryMethod) {

    }

    @Override
    public Map<String, Object> getPropertyKeyValue() {
        return null;
    }

    @Override
    public void setPropertyKeyValue(Map<String, Object> properties) {

    }
}
