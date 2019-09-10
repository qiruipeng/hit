package com.life.hits.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qirp
 * @since: 2018/8/21 19:38
 **/
@Slf4j
public class test {
    public static void main(String[] args) {
        int it = 2;
        log.info("乘2：{}",it << 1);
        log.info("除2：{}",it >> 1);
        Date date1 = new Date("2019-09-04 12:00:00");
        Date date2 = new Date("2019-09-05 12:00:00");
        log.info("{}",date1.before(date2));
    }
}
