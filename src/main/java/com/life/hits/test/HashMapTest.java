package com.life.hits.test;

import java.util.HashMap;
import java.util.Map;

/**
 * hashMap
 * @author: qirp
 * @since: 2019/7/17 11:24
 **/
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        //如果key的hash值一样，会散列在同一个数组链表中，在get的时候如何取出?
        map.put("key","value");
        //key一样会从链表中循环判断获取，8里面先判断是不是红黑树直接返回；7中直接循环取；
        // 但如果链表是环形结构会死循环，get的时候会导致cpu飙升，内存泄露!
        map.get("key");
    }
}
