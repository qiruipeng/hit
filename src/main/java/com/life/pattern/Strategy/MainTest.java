package com.life.pattern.Strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author: qirp
 * @since: 2019/9/2 11:25
 **/
@Slf4j
public class MainTest {
    public static void main(String[] args) {
        Context  yf = new Context("阿迪达斯",new BigDecimal(800),new YFDisCount());
        log.info("{}原价:{},打折后最终价格：{}",yf.getName(),yf.getPrice(),yf.getFinalPrice());
    }
}
