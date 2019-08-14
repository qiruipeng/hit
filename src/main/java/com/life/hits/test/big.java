package com.life.hits.test;

import java.math.BigDecimal;

/**
 * @author: qirp
 * @since: 2018/7/25 12:13
 **/
public class big {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("-100");
        System.out.println(BigDecimal.ZERO.compareTo(a) >= 0);

    }
}
