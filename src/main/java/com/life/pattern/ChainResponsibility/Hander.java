package com.life.pattern.ChainResponsibility;

import lombok.Data;

/**
 * @author: qirp
 * @since: 2019/8/30 17:46
 **/
@Data
public abstract class Hander {

    //处理人名字
    private String name;
    Hander nextHander;

    public Hander(String name) {
        this.name = name;
    }

    /**
     * 处理方法
     * @param request
     * @return
     */
    abstract boolean hander(LeaveRequest request);

}
