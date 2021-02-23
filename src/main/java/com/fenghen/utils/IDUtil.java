package com.fenghen.utils;

import java.util.Date;

public class IDUtil {
    public static String MakeID(){
        Date date = new Date();
        String number = Long.toString(date.getTime());
        return number;
    }
}
