package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 字符串截取性能
 * @author: qirp
 * @since: 2019/8/1 17:16
 **/
@Slf4j
public class StrSplitTest {
    public static void main(String[] args) {
        String str = "2019-08-01";
        newSplit(str);
    }

    static void split(String str){
        log.info(str.split("-")[0]);
    }

    static void newSplit(String str){
        StringTokenizer tokenizer = new StringTokenizer(str,"-");
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        log.info("截取列表:{}",list);
    }
}
