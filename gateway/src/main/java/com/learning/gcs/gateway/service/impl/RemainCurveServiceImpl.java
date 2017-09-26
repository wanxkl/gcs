package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.common.repository.RemainCurveRepository;
import com.learning.gcs.gateway.service.RemainCurveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemainCurveServiceImpl implements RemainCurveService{

    @Autowired
    private RemainCurveRepository remainCurveRepository;

    @Override
    public RemainCurve findOne(Integer id) {
        return remainCurveRepository.findOne(id);
    }

    @Override
    public RemainCurve save(RemainCurve remainCurve) {

        return remainCurveRepository.save(remainCurve);

    }
}
