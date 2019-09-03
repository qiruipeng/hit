package com.life.pattern.Factory.SimpleFactoryPattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: qirp
 * @since: 2019/9/3 10:22
 **/
@Slf4j
public class MainTest {

    @Test
    public void test(){
        VideoFactory factory = new VideoFactory();
        String result = factory.getVideo("java").play();
        log.info("播放{}",result);
    }
}
