package com.life.pattern.Strategy;

import java.math.BigDecimal;

/**
 * 打折类接口，定义算法的名称也就是策略，具体的算法&策略交给子类实现
 * @author: qirp
 * @since: 2019/9/2 11:18
 **/
public interface DisCount {
    /**
     * 获取最终价格
     * @param price
     * @return
     */
    BigDecimal geiFinalPrice(BigDecimal price);
}
