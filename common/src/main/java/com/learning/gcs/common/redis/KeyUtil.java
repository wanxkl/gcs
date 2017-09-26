package com.learning.gcs.common.redis;

public class KeyUtil {

    private static final String  PREFIX_DEVICE_IMEI = "imei:";
    private static final String  PREFIX_DEVICE_ID = "device_id:";
    private static final String  PREFIX_REMAIN_CURVE_ID = "remain_curve:";
    private static final String  PREFIX_TASK_ID_COUNT = "task_Id_count:";
    private static final String  PREFIX_TASK_ID = "task_Id:";
    private static final String  DIVISION = ":";





    public static final String  KEY_TASK_CONFIG = "task_config";



    public static String generateDeviceImeiKey(String key){
        return PREFIX_DEVICE_IMEI+key;
    }
    public static String generateDeviceIdKey(String key){
        return PREFIX_DEVICE_ID+key;
    }
    public static String generateRemainCurveIdKey(Integer remainCurveId){
        return PREFIX_REMAIN_CURVE_ID+remainCurveId;
    }
    public static String generateRemainTaskIdCountKey(Integer taskId){
        return PREFIX_TASK_ID_COUNT+taskId;
    }
    public static String generateRemainTaskIdHourCountKey(Integer taskId,Integer hour){
        return PREFIX_TASK_ID+taskId+DIVISION+hour;
    }
}
