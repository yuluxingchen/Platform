package com.fenghen.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String DatetoString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdate = sdf.format(date);
        return sdate;
    }
}
