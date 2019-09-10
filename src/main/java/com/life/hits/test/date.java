package com.life.hits.test;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: qirp
 * @since: 2018/7/9 13:55
 **/
@Slf4j
public class date {
    public static void main(String[] args) throws ParseException {
        String STANDARD_DATE_FORMAT_UTC = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_FORMAT_UTC);
        Date date1 = sdf.parse("2019-09-05 12:00:00");
        Date date2 = sdf.parse("2019-09-04 12:00:00");
        log.info("{}",date1.before(date2));
    }
}
