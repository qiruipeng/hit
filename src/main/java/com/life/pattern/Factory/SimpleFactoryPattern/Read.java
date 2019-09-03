package com.life.pattern.Factory.SimpleFactoryPattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Calendar;

/**
 * @author: qirp
 * @since: 2019/9/3 10:39
 **/
public class Read {

    @Test
    public void testCalendar(){
        //接口类和工厂逻辑都是Calendar，通过getInstance创建,具体的产品类是Calendar的三个子类
        Calendar calendar = Calendar.getInstance();
    }

    @Test
    public void testJDBCConn() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        //加载mysql驱动DriverManager.registerDriver(new Driver());
        //利用静态块加载Driver并注册到驱动管理器中(CopyOnWriteArrayList<DriverInfo>列表中)
        //这里DriverManager充当工厂类，具体的产品是mysl、oracle等
        Class.forName("com.mysql.jdbc.Driver").newInstance();//oracle.jdbc.OracleDriver
        String url = "jdbc:mysql://172.16.1.157:3306/settlement__20190409?useUnicode=true&characterEncoding=utf-8";

        String passWord = "scc_app";
        String userName = "123456#Abc";

        //获取一个连接
        try {
            //从CopyOnWriteArrayList中获取一个符合条件的驱动
            conn = DriverManager.getConnection(url,userName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoggerFactory(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
    }
}
