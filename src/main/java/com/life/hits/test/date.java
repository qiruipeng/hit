package com.life.hits.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: qirp
 * @since: 2018/7/9 13:55
 **/
public class date {
    public static void main(String[] args) {
        String STANDARD_DATE_FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_FORMAT_UTC);

        System.out.println(sdf.format(new Date()));
    }
}
