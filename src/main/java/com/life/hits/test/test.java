package com.life.hits.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: qirp
 * @since: 2018/8/21 19:38
 **/
public class test {
    public static void main(String[] args) {

        String temp = "[{\"attaId\":\"\",\"dataType\":\"0009\"},{\"attaId\":\"\",\"dataType\":\"0008\"},{\"attaId\":\"644\",\"dataType\":\"0007\"}]";
        List<Map<String,Object>> fileList = new Gson().fromJson(temp, new TypeToken<List<Map<String,Object>>>() {}.getType());
        System.out.println(fileList.get(0));

    }
}
