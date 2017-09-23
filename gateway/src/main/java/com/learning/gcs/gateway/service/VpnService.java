package com.learning.gcs.gateway.service;

import com.learning.gcs.gateway.bean.TaskVpn;

public interface VpnService {

    TaskVpn getVpnByDeviceId(String deviceId);

    TaskVpn getVpnByIp(String ip);
}
