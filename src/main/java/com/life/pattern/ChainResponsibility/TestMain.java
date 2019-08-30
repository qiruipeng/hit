package com.life.pattern.ChainResponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: qirp
 * @since: 2019/8/30 18:01
 **/
@Slf4j
public class TestMain {
    public static void main(String[] args) {
        //创建执行者
        Hander zuzhang = new GroupLeader("王建");
        Hander jingli = new Manager("杨光");
        Hander zongjian = new ChiefInspector("peter");
        //创建责任链
        zuzhang.setNextHander(jingli);
        jingli.setNextHander(zongjian);

        //屁民
        LeaveRequest request = new LeaveRequest();
        request.setName("李四");
        request.setDay(4);

        boolean result1 = zuzhang.hander(request);
        log.info("组长的处理结果{}",result1);
        boolean result2 = jingli.hander(request);
        log.info("经理的处理结果{}",result2);
        boolean result3 = zongjian.hander(request);
        log.info("总监的处理结果{}",result3);


    }
}
