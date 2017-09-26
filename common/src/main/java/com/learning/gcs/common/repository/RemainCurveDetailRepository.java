package com.learning.gcs.common.repository;


import com.learning.gcs.common.entity.RemainCurveDetail;

import java.util.List;

public interface RemainCurveDetailRepository extends MyRepository<RemainCurveDetail,Integer>{

    List<RemainCurveDetail> findByRemainCurveId(Integer remainCurveId);
}
