package com.life.hits.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: qirp
 * @since: 2019/5/29 18:42
 **/
@Data
public class A implements Serializable{
    private String name;
    private String adress;
    private String phone;
    private String nickName;


    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
