package com.life.pattern.ChainResponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 组长处理
 * @author: qirp
 * @since: 2019/8/30 17:49
 **/
@Slf4j
public class GroupLeader extends Hander{

    public GroupLeader(String name) {
        super(name);
    }

    @Override
    boolean hander(LeaveRequest request) {
        int days = request.getDay();
        if(days > 0 && days <= 2){
            return true;
        }
        return this.nextHander.hander(request);
    }
}
