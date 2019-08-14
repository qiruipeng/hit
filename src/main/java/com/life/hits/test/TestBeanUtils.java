package com.life.hits.test;

import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: qirp
 * @since: 2018/7/4 10:29
 **/
public class TestBeanUtils {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAdress("北京市");
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        Customer customer = new Customer();
        BeanUtils.copyProperties(user,customer);
        System.out.println(customer.toString());
    }
}
