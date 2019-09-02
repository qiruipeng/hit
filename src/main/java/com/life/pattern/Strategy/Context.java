package com.life.pattern.Strategy;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 环境类
 * @author: qirp
 * @since: 2019/9/2 11:26
 **/
@Data
public class Context {
    private String name;
    private BigDecimal price;
    private DisCount disCount;

    public Context (String name, BigDecimal price, DisCount disCount) {
        this.name = name;
        this.price = price;
        this.disCount = disCount;
    }

    public BigDecimal getFinalPrice(){
        return disCount.geiFinalPrice(this.price);
    }
}
