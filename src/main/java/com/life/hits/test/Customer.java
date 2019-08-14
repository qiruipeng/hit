package com.life.hits.test;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author: qirp
 * @since: 2018/7/4 10:28
 **/
@Data
public class Customer {
    private String name;
    private String adress;
    private String remark;
    private Timestamp createTime;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
