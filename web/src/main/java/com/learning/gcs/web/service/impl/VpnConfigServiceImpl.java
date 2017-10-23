package com.learning.gcs.web.service.impl;

import com.learning.gcs.common.entity.VpnConfig;
import com.learning.gcs.common.repository.VpnConfigRepository;
import com.learning.gcs.web.service.VpnConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VpnConfigServiceImpl implements VpnConfigService {
    @Autowired
    VpnConfigRepository vpnConfigRepository;
    @Override
    public List<VpnConfig> findAll() {
        return vpnConfigRepository.findAll();
    }

    @Override
    public void updateTime(int id, int time) {
        vpnConfigRepository.updateById(id, time);
    }
}
