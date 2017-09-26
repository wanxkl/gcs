package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.RemainCurveDetail;

import java.io.IOException;
import java.util.List;

public interface RemainCurveDetailService {
    RemainCurveDetail save(RemainCurveDetail remainCurveDetail);
    List<RemainCurveDetail>  getRemainCurveDetailByRemainCurveId(Integer remainCurveId) throws IOException;
}
