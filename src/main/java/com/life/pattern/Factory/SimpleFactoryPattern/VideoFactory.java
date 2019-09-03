package com.life.pattern.Factory.SimpleFactoryPattern;

/**
 * 创建对象返回，可以通过ifelse、switch，也可以利用反射
 * @author: qirp
 * @since: 2019/9/3 10:25
 **/
public class VideoFactory {
    public static Video getVideo(String type){
        if("java".equals(type)){
            return new JavaVideo();
        }else{
            return new VueVideo();
        }
    }
}
