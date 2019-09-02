package com.life.pattern.Strategy;

import java.math.BigDecimal;

/**
 * 衣服类打八折
 * @author: qirp
 * @since: 2019/9/2 11:23
 **/
public class YFDisCount implements DisCount{
    @Override
    public BigDecimal geiFinalPrice(BigDecimal price) {
        return price.multiply(new BigDecimal(0.8));
    }
}
