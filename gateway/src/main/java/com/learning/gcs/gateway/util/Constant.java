package com.learning.gcs.gateway.util;

import com.learning.gcs.gateway.bean.Result;
import com.learning.gcs.gateway.bean.TaskConfig;

public class Constant {

    public static final Result RESULT_SUCCESS = new Result(1,"success");
    public static final Result RESULT_FAIL = new Result(0,"fail");
    public static final String SCHEDULE_TOGGLE_ENABLE = "enable";

    public static final TaskConfig TASK_CONFIG_INVALID_TASK = new TaskConfig(false,"该asoId没有合适的Task");
    public static final TaskConfig TASK_CONFIG_INVALID_DEVICE_INFO = new TaskConfig(false,"TASK没有合适的DeviceInfo");
    public static final TaskConfig TASK_CONFIG_DONE_HOUR = new TaskConfig(false,"当前小时任务已做完");

    public static final Integer GCS_TASK_MODE_CODE_CPA = 1;
    public static final Integer GCS_TASK_MODE_CODE_MARKET = 2;

    public static final String CHARSET = "UTF-8";


    public static final String HOST_SYN_PHONE_NUMBER = "http://42.96.169.232:8081/sp/getLatelyTel?latelyTime=1&opType=";
    public static final String HOST_SYN_PHONE_CAPTCHA = "http://42.96.169.232:8081/sp/getLatelyCode";

}
