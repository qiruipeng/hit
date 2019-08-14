package com.life.hits.test;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * @author: qirp
 * @since: 2018/12/5 11:23
 **/
@Logger
public class test01 {
    public static void main(String[] args) {
        List<Integer> tempList = Arrays.asList(new Integer [] {1,2,3,4,0,6});
        for(Integer a : tempList){
            int b = 30;
            try {
                int c = b/a;
                System.out.println(c);
            }catch (Exception e){
//                e.printStackTrace();
                System.out.println("遇到错了，继续执行");
            }
        }
    }
}
