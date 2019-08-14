package com.life.hits.test;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author: qirp
 * @since: 2018/6/20 19:42
 **/
@Data
public class User {
    private String name;
    private String pwd;
    private String adress;
    private String remark;
    private Timestamp createTime;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", adress='" + adress + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
