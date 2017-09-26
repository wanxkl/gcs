package com.learning.gcs.gateway.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    private static final String FORMAT_HOUR = "HH";
    private static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentHour(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HOUR);
        return simpleDateFormat.format(new Date());
    }

    public static String getFormatDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getCurrentHour());
    }
}
