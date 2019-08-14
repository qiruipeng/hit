package com.life.hits.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: qirp
 * @since: 2019/7/16 15:44
 **/
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String,Object> cMap = new ConcurrentHashMap();
        cMap.put("key","value");
    }
}
