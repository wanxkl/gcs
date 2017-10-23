package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.BlackList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BlackListRepository extends MyRepository<BlackList,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update BlackList b set b.blackName=:blackName where b.id=:id")
    void updateById(@Param("id") int id, @Param("blackName") String blackName);
}
