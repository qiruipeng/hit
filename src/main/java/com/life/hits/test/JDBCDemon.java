package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * 一个简单的jdbc连接demo
 * @author: qirp
 * @since: 2019/7/11 14:35
 **/
@Slf4j
public class JDBCDemon {
    public static void main(String[] args) {
        queryList();
    }

    public static List<Map<String,String>> queryList(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            //加载mysql驱动
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://172.16.1.157:3306/settlement__20190409?useUnicode=true&characterEncoding=utf-8";

            String passWord = "scc_app";
            String userName = "123456#Abc";

            //获取一个连接
            conn = DriverManager.getConnection(url,userName,passWord);

            String sql = "SELECT * FROM `t_n_contract` t WHERE t.`CONTRACT_NUM` = ?";

            //添加参数
            stmt.setString(1,"200201806734933");
            //创建一个预加载对象
            stmt = conn.prepareStatement(sql);
            //执行语句
            rs = stmt.executeQuery();
            log.info("......");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
