package com.learning.gcs.common.repository;

import com.learning.gcs.common.entity.GcsTaskConfig;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface GcsTaskConfigRepository extends MyRepository<GcsTaskConfig,Integer>{

    @Transactional
    @Modifying(clearAutomatically =true)
    @Query("update GcsTaskConfig c set c.luaUrl=:luaUrl,c.runTimeMax=:runTimeMax,c.version=:version,c.state=:state where c.id=:id limit 1")
    void updateById(@Param("id") int id,@Param("luaUrl") String luaUrl, @Param("runTimeMax") int runTimeMax, @Param("version") int version,@Param("state") boolean state);

    GcsTaskConfig findTopByOrderByCreateTimeDesc();
}
