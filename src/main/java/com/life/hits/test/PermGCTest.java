package com.life.hits.test;

import org.junit.Test;

import java.util.Vector;

/**
 * @author: qirp
 * @since: 2019/8/21 16:18
 **/
public class PermGCTest {

    //VM配置：-XX:PermSize=2M -XX:MaxPermSize=4M -XX:+PrintGCDetails
    //常量池满了导致GC
    @Test
    public void permTest(){
        for(int i = 0;i<Integer.MAX_VALUE;i++){
            String t = String.valueOf(i).intern();
        }
    }

    //VM配置：-Xmx11M -Xms5M -verbose:gc
    @Test
    public void gcTest(){
        Vector v = new Vector();
        for(int i = 0;i < 10;i++){
            byte[] b = new byte[1024*1024];
            v.add(b);
            if(v.size() == 3){
                v.clear();
            }

        }
    }


}
