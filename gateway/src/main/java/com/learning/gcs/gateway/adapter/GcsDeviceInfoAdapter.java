package com.learning.gcs.gateway.adapter;

import com.learning.gcs.common.entity.GcsDeviceInfo;
import com.learning.gcs.gateway.bean.MxDeviceInfo;
import org.springframework.util.StringUtils;

public class GcsDeviceInfoAdapter {

    private MxDeviceInfo mxDeviceInfo;

    public GcsDeviceInfoAdapter(MxDeviceInfo mxDeviceInfo) {
        this.mxDeviceInfo = mxDeviceInfo;
    }

    public GcsDeviceInfo build(){
        GcsDeviceInfo gcsDeviceInfo = new GcsDeviceInfo();
        gcsDeviceInfo.setImei(mxDeviceInfo.getImei());
        gcsDeviceInfo.setPhone(mxDeviceInfo.getPhone());
        gcsDeviceInfo.setHardware(mxDeviceInfo.getHardware());
        gcsDeviceInfo.setUserAgent(mxDeviceInfo.getUserAgent());
        gcsDeviceInfo.setWifiname(mxDeviceInfo.getWifiname());
        gcsDeviceInfo.setCpuAbi2(mxDeviceInfo.getCpuAbi2());
        gcsDeviceInfo.setSdkInt(mxDeviceInfo.getSdkInt());
        gcsDeviceInfo.setAndroidId(mxDeviceInfo.getAndroidId());
        gcsDeviceInfo.setIccid(mxDeviceInfo.getIccid());
        gcsDeviceInfo.setMac(mxDeviceInfo.getMac());
        gcsDeviceInfo.setFingerprint(mxDeviceInfo.getFingerprint());
        gcsDeviceInfo.setBluetouth(mxDeviceInfo.getBluetouth());
        gcsDeviceInfo.setOpType(mxDeviceInfo.getOpType());
        gcsDeviceInfo.setBootloader(mxDeviceInfo.getBootloader());
        gcsDeviceInfo.setDisplay(mxDeviceInfo.getDisplay());
        gcsDeviceInfo.setBoard(mxDeviceInfo.getBoard());
        gcsDeviceInfo.setDayTime(mxDeviceInfo.getDayTime());
        gcsDeviceInfo.setProduct(mxDeviceInfo.getProduct());
        gcsDeviceInfo.setCpumodel(mxDeviceInfo.getCpumodel());
        gcsDeviceInfo.setCpuAbi(mxDeviceInfo.getCpuAbi());
        gcsDeviceInfo.setRam(mxDeviceInfo.getRam());
        gcsDeviceInfo.setManufacturer(mxDeviceInfo.getManufacturer());
        gcsDeviceInfo.setDevice(mxDeviceInfo.getDevice());
        gcsDeviceInfo.setUa(mxDeviceInfo.getUa());
        gcsDeviceInfo.setBrand(mxDeviceInfo.getBrand());
        gcsDeviceInfo.setIncremental(mxDeviceInfo.getIncremental());
        gcsDeviceInfo.setClientIp(mxDeviceInfo.getClientIp());
        gcsDeviceInfo.setImsi(mxDeviceInfo.getImsi());
        gcsDeviceInfo.setSerial(mxDeviceInfo.getSerial());
        gcsDeviceInfo.setXgver(mxDeviceInfo.getXgver());
        gcsDeviceInfo.setDeviceRelease(mxDeviceInfo.getRelease());

        String location = mxDeviceInfo.getLocation();
        if(!StringUtils.isEmpty(location)&&location.contains("_")){
            String [] locationArr = location.split("_");
            gcsDeviceInfo.setCellid(locationArr[0]);
            gcsDeviceInfo.setLac(locationArr[1]);
        }

        String screen = mxDeviceInfo.getScreen();

        if(!StringUtils.isEmpty(screen)&&screen.contains("*")){
            String [] screenArr = screen.split("\\*");
            gcsDeviceInfo.setWidth(screenArr[0]);
            gcsDeviceInfo.setHeight(screenArr[1]);
        }

        gcsDeviceInfo.setDpi(getRandomDpi());
        return gcsDeviceInfo;

    }

    public String getRandomDpi(){
        return System.currentTimeMillis()%2==0?"320":"480";
    }


}
