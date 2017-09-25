package com.learning.gcs.gateway.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MxDeviceInfo {
    private String imei;
    private String phone;
    private String hardware;
    private String userAgent;
    private String wifiname;
    @JsonProperty("cpu_abi2")
    private String cpuAbi2;
    private String sdkInt;
    private String androidId;
    private String iccid;
    private String mac;
    private String fingerprint;
    private String bluetouth;
    private String opType;
    private String bootloader;
    private String display;
    private String board;
    private String dayTime;
    private String product;
    private String cpumodel;
    @JsonProperty("cpu_abi")
    private String cpuAbi;
    private String ram;
    private String manufacturer;
    private String device;
    private String ua;
    private String brand;
    private String incremental;
    private String clientIp;
    private String imsi;
    private String serial;
    private String screen;
    private String location;
    private String dpi;
    private String xgver;
    @JsonProperty("index_num")
    private String indexNum;

    private String release;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getWifiname() {
        return wifiname;
    }

    public void setWifiname(String wifiname) {
        this.wifiname = wifiname;
    }

    public String getCpuAbi2() {
        return cpuAbi2;
    }

    public void setCpuAbi2(String cpuAbi2) {
        this.cpuAbi2 = cpuAbi2;
    }

    public String getSdkInt() {
        return sdkInt;
    }

    public void setSdkInt(String sdkInt) {
        this.sdkInt = sdkInt;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getBluetouth() {
        return bluetouth;
    }

    public void setBluetouth(String bluetouth) {
        this.bluetouth = bluetouth;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCpumodel() {
        return cpumodel;
    }

    public void setCpumodel(String cpumodel) {
        this.cpumodel = cpumodel;
    }

    public String getCpuAbi() {
        return cpuAbi;
    }

    public void setCpuAbi(String cpuAbi) {
        this.cpuAbi = cpuAbi;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIncremental() {
        return incremental;
    }

    public void setIncremental(String incremental) {
        this.incremental = incremental;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getXgver() {
        return xgver;
    }

    public void setXgver(String xgver) {
        this.xgver = xgver;
    }

    public String getIndexNum() {
        return indexNum;
    }

    public void setIndexNum(String indexNum) {
        this.indexNum = indexNum;
    }
    public String getRelease() {
        return release;
    }
    public void setRelease(String release) {
        this.release = release;
    }
}
