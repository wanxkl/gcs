package com.learning.gcs.gateway.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.entity.RemainCurveDetail;
import com.learning.gcs.common.redis.KeyUtil;
import com.learning.gcs.common.redis.RedisReader;
import com.learning.gcs.common.redis.RedisWriter;
import com.learning.gcs.common.repository.RemainCurveDetailRepository;
import com.learning.gcs.gateway.service.RemainCurveDetailService;
import com.learning.gcs.gateway.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.List;

@Service
public class RemainCurveDetailServiceImpl implements RemainCurveDetailService{

    @Autowired
    private RedisReader redisReader;
    @Autowired
    private RedisWriter redisWriter;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RemainCurveDetailRepository remainCurveDetailRepository;

    @Override
    public RemainCurveDetail save(RemainCurveDetail remainCurveDetail) {
        return remainCurveDetailRepository.save(remainCurveDetail);
    }

    @Override
    public List<RemainCurveDetail> getRemainCurveDetailByRemainCurveId(Integer remainCurveId) throws IOException {
        List<RemainCurveDetail> details = null;
        Object o = redisReader.get(KeyUtil.generateRemainCurveIdKey(remainCurveId));
        if(ObjectUtils.isEmpty(o)){
            details = remainCurveDetailRepository.findByRemainCurveId(remainCurveId);
            if(!ObjectUtils.isEmpty(details)){
                redisWriter.set(KeyUtil.generateRemainCurveIdKey(remainCurveId),objectMapper.writeValueAsString(details));
            }
        }else{
            details = objectMapper.readValue(o.toString(), ObjectMapperUtil.getCollectionType(objectMapper,List.class,RemainCurveDetail.class));
        }
        return details;
    }
}
