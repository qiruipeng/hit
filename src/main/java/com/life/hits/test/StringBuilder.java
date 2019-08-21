package com.life.hits.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * stringBuffer和StringBuilder的区别
 * @author: qirp
 * @since: 2019/8/1 17:33
 **/
public class StringBuilder {
    static String str = "";

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("");
        buffer.append("1");

        //String字符串拼接，会不停的在常量池中创建新的对象，并将新的对象的内存地址指向字符串的引用
        String str = new String();
        str = str + "123";
    }

    static void StringBuilderTest(){
        ExecutorService service = Executors.newFixedThreadPool(10);
        java.lang.StringBuilder builder = new java.lang.StringBuilder(str);
        for(int i = 0;i<10;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                }
            });
        }

    }
}
