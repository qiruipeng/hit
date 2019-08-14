package com.life.hits.test;

import com.mysql.jdbc.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 常用转化8的实现方式
 * @author: qirp
 * @since: 2018/6/20 17:52
 **/
public class UsualDemo {

    public static List<Map> list = new ArrayList<>();
    public static Map<String, Integer> items = new LinkedHashMap<>();
    public static List<User> list1 = new ArrayList<>();
    static {
        items.put("小白", 10);
        items.put("小文", 20);
        items.put("小君", 30);
        items.put("KD", 40);
        items.put("ws", 50);
        items.put("XJ", 60);
        list.add(items);
        User user = new User();
        user.setName("李四");
        user.setPwd("12234");
        list1.add(user);
        User user1 = new User();
        user.setName("王五");
        user.setPwd("12234");
        list1.add(user1);
    }

    public static void main(String[] args) {
        sum();
    }

    /**
     * list转map
     */
    public static void list2Map(){
        System.out.println(list1);
        Map<String,String> map = list1.stream().collect(Collectors.toMap(User::getPwd,User::getName));
        System.out.println(map);
    }

    private String convertPara(Map<String,Object> para,List<String> ignore,String alias){
        for(String str : ignore){
            para.remove(str);
        }
        String result = "";
        for(Map.Entry entry : para.entrySet()){
            if(!StringUtils.isNullOrEmpty(entry.getValue().toString())){
                result += " and " + alias + "." +entry.getKey() + "= :" + entry.getKey();
            }
        }
        return result;
    }

    private String convertPara1(Map<String,Object> para,List<String> ignore,String alias){
        ignore.forEach(t -> para.remove(t));
        String result = "";
//        para.forEach(t -> System.out::println());
        return result;
    }
    private static void math(){
        DoubleUnaryOperator y = x -> Math.sqrt(3);
        System.out.println(y.applyAsDouble(0));
    }

    private static  void sum(){
        List<Integer> data = Arrays.asList(1,2,3);
        int sums = 0;
//        data.forEach(e -> {sums += e;});//非法写法
        data.forEach(e -> System.out.println(e));
        sums = data.stream().mapToInt(value -> value).sum();
        System.out.println("计算结果为：" + sums);
//        List<Integer> list = ArrayList::new;
    }

    private static void test(){

    }


}
