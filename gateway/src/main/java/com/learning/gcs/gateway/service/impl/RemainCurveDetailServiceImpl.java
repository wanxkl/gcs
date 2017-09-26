package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.RemainCurveDetail;
import com.learning.gcs.common.repository.RemainCurveDetailRepository;
import com.learning.gcs.gateway.service.RemainCurveDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemainCurveDetailServiceImpl implements RemainCurveDetailService{

    @Autowired
    private RemainCurveDetailRepository remainCurveDetailRepository;

    @Override
    public RemainCurveDetail save(RemainCurveDetail remainCurveDetail) {
        return remainCurveDetailRepository.save(remainCurveDetail);
    }
}
