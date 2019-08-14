package com.life.hits.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: qirp
 * @since: 2018/8/12 18:00
 **/
public class DD {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> number1 = Arrays.asList(7, 3, 4);
        List<Integer> result = new ArrayList<>();
        for(Integer l1 : numbers){
            Integer num = l1;
            boolean ix = false;
            for(Integer l2 : number1){
                if(num == l2){
                    ix = true;
                    System.out.println("有相同的数据:" + num);
                    break;
                }
            }
            if(!ix){
                result.add(num);
            }
        }
        System.out.println("最后的结果为:" + result);
    }
}
