package com.life.hits.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 形成换结构，然后get操作
 * @author: qirp
 * @since: 2019/7/29 16:15
 **/
public class HashMapDeadLock {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
                }, "HashMapDemo-" + i).start();
            }
        });

        t.start();
        t.join();
    }
}
