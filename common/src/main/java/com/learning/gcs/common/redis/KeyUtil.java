package com.learning.gcs.common.redis;

public class KeyUtil {

    private static final String  PREFIX_DEVICE_IMEI = "imei:";
    private static final String  PREFIX_DEVICE_ID = "device_id:";



    public static final String  KEY_TASK_CONFIG = "task_config";



    public static String generatDeviceImeiKey(String key){
        return PREFIX_DEVICE_IMEI+key;
    }
    public static String generatDeviceIdKey(String key){
        return PREFIX_DEVICE_ID+key;
    }
}
