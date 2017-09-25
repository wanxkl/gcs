package com.learning.gcs.gateway.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.GcsDeviceInfoRepository;
import com.learning.gcs.common.util.HttpUtil;
import com.learning.gcs.gateway.adapter.GcsDeviceInfoAdapter;
import com.learning.gcs.gateway.bean.MxDeviceInfoBean;
import com.learning.gcs.gateway.service.GcsDeviceInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class GcsDeviceInfoServiceImpl implements GcsDeviceInfoService{

    private static final Logger logger = LoggerFactory.getLogger(GcsDeviceInfoServiceImpl.class);

    private static final String URL = "http://42.96.169.232:8081/sp/getDicDevicesInfo?num=1&opType=1";

    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GcsDeviceInfoRepository gcsDeviceInfoRepository;

    @Override
    public GcsDeviceInfo getByTaskId(Integer taskId) {

        //判断taskId任务类型
        GcsDeviceInfo gcsDeviceInfo = newGcsDeviceInfo(taskId);

        gcsDeviceInfoRepository.save(gcsDeviceInfo);
        try {
            redisWriter.set(KeyUtil.generatDeviceImeiKey(gcsDeviceInfo.getImei()),
                    objectMapper.writeValueAsString(gcsDeviceInfo),
                    2, TimeUnit.DAYS);
        } catch (JsonProcessingException e) {
            logger.error("gcsDeviceInfo 转化异常:{}",e);
        }
        return gcsDeviceInfo;
    }

    @Override
    public GcsDeviceInfo save(GcsDeviceInfo gcsDeviceInfo) {
        return gcsDeviceInfoRepository.save(gcsDeviceInfo);
    }

    private GcsDeviceInfo newGcsDeviceInfo(Integer taskId) {
        String responseString  = HttpUtil.sendGet(URL,"UTF-8");
        MxDeviceInfoBean mxDeviceInfoBean = null;
        try {
            mxDeviceInfoBean = new ObjectMapper().readValue(responseString,MxDeviceInfoBean.class );
        } catch (IOException e) {
            logger.error("mxDeviceInfoBean 转化异常:{}",e);
        }
        return  new GcsDeviceInfoAdapter(mxDeviceInfoBean.getDevicesInfo()).build();
    }
}
