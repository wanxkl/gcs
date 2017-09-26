package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.RemainCurve;

public interface RemainCurveService {

    RemainCurve findOne(Integer id);

    RemainCurve save(RemainCurve remainCurve);

}
