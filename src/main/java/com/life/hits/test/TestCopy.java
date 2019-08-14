package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.cglib.beans.BeanCopier;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: qirp
 * @since: 2019/5/29 18:43
 **/
@Slf4j
public class TestCopy {

    @Test
    public void copy(){
        A a= new A();
        B b= new B();
        a.setName("zhangsan");
        a.setNickName("zhangerwa");
        b.setPhone("123456");
        log.info(a.toString());
        log.info(b.toString());
        //将a的属性copy到b，如果a中有空的就忽略
        BeanUtils.copyProperties(b,a,getNullPropertyNames(b));
        log.info(a.toString());
        log.info(b.toString());
    }

    @Test
    public void BeanCopier(){
        final BeanCopier copier = BeanCopier.create(A.class, B.class, false);
        A a= new A();
        B b= new B();
        a.setName("zhangsan");
        a.setNickName("zhangerwa");
        b.setPhone("123456");
        log.info(a.toString());
        log.info(b.toString());
        copier.copy(a,b,null);
        log.info(a.toString());
        log.info(b.toString());
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
