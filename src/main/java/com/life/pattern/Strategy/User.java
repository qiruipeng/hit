package com.life.pattern.Strategy;

import lombok.Data;

/**
 * @author: qirp
 * @since: 2019/9/2 14:17
 **/
@Data
public class User {

     //无参构造函数
    public User() {
    }

    //带参构造函数
    public User(String name) {
        this.name = name;
    }

    private String name;
    private String adress;
    private String phone;
}
