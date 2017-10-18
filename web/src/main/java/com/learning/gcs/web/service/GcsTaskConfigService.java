package com.learning.gcs.web.service;

import com.learning.gcs.common.entity.GcsTaskConfig;

public interface GcsTaskConfigService  {
    /**
     * 查询任务列表最新一条数据
     *
     * @return
     */
    GcsTaskConfig findNewGcsTaskConfig();

    /**
     * 修改表
     * @param id
     */
    void updateById(int id,String luaUrl,int runTimeMax,int version,boolean state);
}
