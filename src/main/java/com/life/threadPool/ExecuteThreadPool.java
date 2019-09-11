package com.life.threadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: qirp
 * @since: 2019/9/11 14:39
 **/
public class ExecuteThreadPool {

    @Test
    public void testFixThreadPool(){
        ExecutorService service = Executors.newFixedThreadPool(10);
    }
}
