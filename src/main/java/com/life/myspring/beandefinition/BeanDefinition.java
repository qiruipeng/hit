package com.life.myspring.beandefinition;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 对bean定义的接口
 * @author: qirp
 * @since: 2019/7/5 12:06
 **/
public interface BeanDefinition {

    String SINGLETION = "singleton";

    String PROTOTYPE = "prototype";

    /**
     * 获取bean的字节码对象
     * @return
     */
    Class<?> getBeanClass();

    String getBeanName();

    /**
     * 获取创建bean的工厂名
     * @return
     */
    String getBeanFactory();

    /**
     * 获取创建bean的实例方法
     * @return
     */
    String getCreateBeanMethod();

    String getStaticCreateBeanMethod();

    String getBeanInitMethodName();

    String getBeanDestoryMethodName();

    /**
     * 获取bean的类型
     * @return
     */
    String getScope();

    boolean isSingleton();

    boolean isPrototype();

    /**
     * 校验传入的bean定义是否正确
     * @return
     */
    default boolean validate(){

        if(getBeanClass() == null){
            //字节码文件为空 并且创建bean的工厂为空 不合法
            if(StringUtils.isBlank(getBeanFactory()) && StringUtils.isBlank(getCreateBeanMethod())){
                return false;
            }
        }
        return true;
    }

    //DI

    /**
     * 传入的构造参数
     * @return
     */
    List<?> getConstructorArg();

    //下面的方法时为了缓存相应的调用方法
    Constructor<?> getConstructor();
    void setConstructor(Constructor<?> constructor);
    Method getFactoryMethod();
    void setFactoryMethod(Method factoryMethod);

    //属性依赖
    Map<String,Object> getPropertyKeyValue();
    void setPropertyKeyValue(Map<String,Object> properties);
}
