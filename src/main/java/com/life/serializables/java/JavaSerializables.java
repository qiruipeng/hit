package com.life.serializables.java;

import com.life.serializables.AbstractSerializable;
import com.life.serializables.Dto.User;

import java.io.*;
import java.util.List;

/**
 * @author: qirp
 * @since: 2019/8/15 10:48
 **/
public class JavaSerializables extends AbstractSerializable {
    @Override
    public void doSerializable(List<?> list) {
        Long t1 = System.currentTimeMillis();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream obj = null;
        try {
            obj = new ObjectOutputStream(out);
            obj.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("java serialize: " +(System.currentTimeMillis() - t1) + "ms; 总大小：" + out.toByteArray().length );

        Long t2 = System.currentTimeMillis();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(out.toByteArray())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = null;
        try {
            user = (User) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("java deserialize: " + (System.currentTimeMillis() - t2) + "ms; User: " + user);
    }
}
