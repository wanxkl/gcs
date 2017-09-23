package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.gateway.bean.TaskVpn;
import com.learning.gcs.gateway.service.VpnService;
import org.springframework.stereotype.Service;

@Service
public class VpnServiceImpl implements VpnService{

    @Override
    public TaskVpn getVpnByDeviceId(String deviceId) {
        return new TaskVpn("miuiad"+deviceId,"miuiad"+deviceId);
    }

    @Override
    public TaskVpn getVpnByIp(String ip) {
        return null;
    }
}
