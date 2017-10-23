package com.learning.gcs.web.service;

import com.learning.gcs.common.entity.BlackList;
import com.learning.gcs.common.entity.GcsTaskOverview;

import java.util.List;

public interface BlackListService {
    /**
     * 保存
     * @param blackName
     */
    void save(String blackName);
    /**
     * 查看黑名单
     * @return
     */
    List<BlackList> findAll();

    /**
     * 修改
     * @param id
     */
    void updateById(int id,String blackName);

    /**
     * 删除
     * @param id
     */
    void delete(int id);

    /**
     *查询黑名单中的的一个
     * @param id
     * @return
     */
    BlackList findOne(int id);
}
