package com.learning.gcs.web.service;

import com.learning.gcs.common.entity.VpnConfig;

import java.util.List;

public interface VpnConfigService {
    /**
     * 查看vpn设置
     * @return
     */
    List<VpnConfig> findAll();

    /**
     *修改vpn超市时间
     * @param id
     */
    void updateTime(int id,int time);
}
