package com.learning.gcs.common.redis;

/*
    Redis 内存数据结构知识
 */
public class RedisDBKnowledge {

    /**
     *  设备信息缓存库 48小时过期
     *  imei:{GscDeviceInfo.imei}->GcsDeviceInfo
     *
     *  任务小时完成数 12小时过期（未完成）
     *  task_Id:{taskId}:{hour}:done->Atomic
     *
     *  任务小时计划数
     *  12小时过期 （未完成）
     *  留存日期更新时过期 （未完成）
     *  task_Id:{taskId}:{hour}:plan->Integer
     *
     *  task_id:{taskId}:remain:date->
     *  task_id:{taskId}:remain:rt->
     *
     *  留存曲线 永不过期  更新时删除
     *  remain_curve:{remainCurveId}->List<RemainCurveDetail>
     *
     *
     *  任务全局配置  永不过期  更新时删除
     *  task_config->TaskConfig
     *
     *
     *  task_id:{taskId}:imei
     *
     *
     */
}
