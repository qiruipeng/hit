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
