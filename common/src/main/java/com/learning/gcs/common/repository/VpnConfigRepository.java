package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.VpnConfig;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VpnConfigRepository extends MyRepository<VpnConfig,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update VpnConfig v set v.outTime=:time where v.id=:id")
    void updateById(@Param("id") int id,@Param("time") int time);
}
