package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: qirp
 * @since: 2019/7/17 14:16
 **/
@Slf4j
public class CopyOnWriteArrayListTest {

//    private static List<String> list = new ArrayList<>();
    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iterator = list.iterator();

        ExecutorService service = Executors.newFixedThreadPool(10);

        //模拟写的场景
        for(int i = 0;i< 10;i++){
            service.execute(() -> {
                while (iterator.hasNext()) {
                    System.err.println(iterator.next());
                }
            });
        }

        //模拟写的场景
        for(int i = 0;i< 10;i++){
            service.execute(() -> list.add("r"));
        }
        System.err.println(Arrays.toString(list.toArray()));

    }
}
