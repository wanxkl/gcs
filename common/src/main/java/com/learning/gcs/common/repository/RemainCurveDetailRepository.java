package com.learning.gcs.common.repository;


import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.common.entity.RemainCurveDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RemainCurveDetailRepository extends MyRepository<RemainCurveDetail,Integer>{

    List<RemainCurveDetail> findByRemainCurveId(Integer remainCurveId);
    @Transactional
    @Modifying
    @Query("update RemainCurveDetail r set r.percent=:percent where r.remainCurve=:remainCurve and r.distance=:distance")
    void updateRemainDetailCurveById(@Param("distance")int distance, @Param("percent")float percent,@Param("remainCurve") RemainCurve remainCurve);
}
