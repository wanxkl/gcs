package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.RemainCurve;
import com.learning.gcs.common.entity.RemainCurveDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RemainCurveRepository extends MyRepository<RemainCurve,Integer>{

    @Transactional
    @Modifying
    @Query("update RemainCurve r set r.remainCurveDetails=:remainCurveDetails where r.id=:id")
    void updateRemainCurveById(@Param("id")int id,@Param("remainCurveDetails")List<RemainCurveDetail> remainCurveDetails);
}
