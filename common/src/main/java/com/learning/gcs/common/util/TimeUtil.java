package com.learning.gcs.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    private static final String FORMAT_HOUR = "HH";
    private static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_DATE = "yyyy-MM-dd";

    public static String getCurrentHour(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HOUR);
        return simpleDateFormat.format(new Date());
    }

    public static String getFormatTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_TIME);
        return simpleDateFormat.format(new Date());
    }

    public static String getFormatDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
        return simpleDateFormat.format(new Date());
    }
    public static String getFormatDateDistinceNow(Integer distainct){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,-distainct);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
        return simpleDateFormat.format(calendar.getTime());
    }


    public static void main(String[] args) {
        System.out.println(getCurrentHour());
    }
}
