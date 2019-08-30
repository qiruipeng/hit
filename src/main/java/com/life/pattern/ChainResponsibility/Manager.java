package com.life.pattern.ChainResponsibility;

/**
 * 经理处理
 * @author: qirp
 * @since: 2019/8/30 17:49
 **/
public class Manager extends Hander{

    public Manager(String name) {
        super(name);
    }

    @Override
    boolean hander(LeaveRequest request) {
        int days = request.getDay();
        if(days > 2 && days <= 4){
            return true;
        }
        return this.nextHander.hander(request);
    }
}
