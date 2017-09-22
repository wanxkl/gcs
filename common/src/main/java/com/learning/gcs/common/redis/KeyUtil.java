package com.learning.gcs.common.redis;

public class KeyUtil {

    private static final String  PREFIX_DEVICE = "imei:";

    public String generatDeviceKey(String key){
        return PREFIX_DEVICE+key;
    }
}
