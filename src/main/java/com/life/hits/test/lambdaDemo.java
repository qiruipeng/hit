package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class lambdaDemo {
    public static void main(String[] args) {
        filter();
    }

    public static void treadTest(){
        //8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("8之前是这个样子。。。");
            }
        }).start();
        //8
        new Thread(()->System.out.println("8之后是这个样子。。。")).start();
    }

    public static void listTest(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
        Object result = features.stream().filter(n -> n.equals("Stream API")).collect(Collectors.toList());
        System.out.println("过滤后的值：" + result);
    }

    public static void max(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt((x)-> x).summaryStatistics();
        System.out.println("最大值：" + statistics.getMax());
        System.out.println("最小值：" + statistics.getMin());
    }

    public static void distinct(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> list = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("去重后的列表值：" + list);
    }

    public static void filter(){
        List<Integer> numbers = Arrays.asList(2,4,5,7);
        List<Integer> list = numbers.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * n*0.12并逐个打印
     */
    public static void reduce(){
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((i) -> i + .12*i).forEach(System.out :: println);
    }

    /**
     * 空指针处理
     */
    public static void nullPointExc(){
        String str = null;
    }

    /**
     * map合并处理
     */
    public static void mergeMap(){
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("zhang1","zhang1");
        map1.put("zhang2","zhang2");
        map1.put("zhang3","zhang3");

        map2.put("li1","li1");
        map2.put("li2","li2");
        map2.put("li3","li3");

        Map<String,String> map3 = new HashMap<>(map1);
        System.out.println(map3);

        map2.forEach((key, value) ->
                map3.merge(key, value,(v1,v2) -> new String(v1)));
        System.out.println(map3);






    }

    /**
     * list合并处理
     */
    public static void mergeList(){

    }
}
