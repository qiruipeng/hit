package com.life.hits.test;

import lombok.Data;

/**
 * @author: qirp
 * @since: 2019/5/29 18:42
 **/
@Data
public class B {
    private String name;
    private String adress;
    private String phone;

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
