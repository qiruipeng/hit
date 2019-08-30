package com.life.pattern.ChainResponsibility;

/**
 * 总监处理
 * @author: qirp
 * @since: 2019/8/30 17:50
 **/
public class ChiefInspector extends Hander{

    public ChiefInspector(String name) {
        super(name);
    }

    @Override
    boolean hander(LeaveRequest request) {
        int days = request.getDay();
        if(days > 4 && days <= 7){
            return true;
        }
        return false;
    }
}
