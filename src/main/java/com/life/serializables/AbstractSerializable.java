package com.life.serializables;

import com.life.serializables.Dto.User;

import java.util.ArrayList;
import java.util.List;

/**
 *  序列化抽象
 * @author: qirp
 * @since: 2019/8/15 10:30
 **/
public abstract class AbstractSerializable {

    public List<?> getList(){
        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setUserName("张三");
        u1.setAdress("北京中观村");
        list.add(u1);
        User u2 = new User();
        u1.setUserName("李四");
        u1.setAdress("北京中观村");
        list.add(u2);
        User u3 = new User();
        u1.setUserName("王五");
        u1.setAdress("北京中观村");
        list.add(u3);
        User u4 = new User();
        u1.setUserName("赵柳");
        u1.setAdress("北京中观村");
        list.add(u4);
        return list;
    }

    public abstract void doSerializable(List<?> list);

}
