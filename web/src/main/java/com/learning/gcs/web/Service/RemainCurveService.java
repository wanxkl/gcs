package com.learning.gcs.web.Service;

import com.learning.gcs.common.entity.RemainCurve;

import java.util.ArrayList;
import java.util.List;

public interface RemainCurveService {

    /**
     * 新增
     */
   void saveRemainDetail(String[] datas, String remainName, int remainType);

    /**
     * 获取曲线
     * @return
     */
     List getRemainDetail();

    /**
     * 查询一条曲线
     * @param id 曲线id
     * @return 曲线实体
     */
    RemainCurve findOne(int id);
    /**
     * 修改曲线百分比
     */
    void updateRemainDetail(String remainName,int remainType,int id,String[] pencents);

    /**
     * 删除曲线
     * @param id 曲线id
     */
    void deleteRemain(int id);
}
