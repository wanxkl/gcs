package com.learning.gcs.gateway.service.impl;

import com.learning.gcs.gateway.bean.TaskVpn;
import com.learning.gcs.gateway.service.VpnService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VpnServiceImpl implements VpnService{

    @Override
    public TaskVpn getVpnByDeviceId(String deviceId) {

        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(deviceId);
        String vpnFlag  = "miuiad"+m.replaceAll("").trim();

        return new TaskVpn(vpnFlag,vpnFlag);
    }

    @Override
    public TaskVpn getVpnByIp(String ip) {
        return null;
    }
}
