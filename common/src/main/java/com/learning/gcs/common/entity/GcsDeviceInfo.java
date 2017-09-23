package com.learning.gcs.common.entity;

//import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GcsDeviceInfo")
@NamedQuery(name = "GcsDeviceInfo", query = "SELECT a FROM GcsDeviceInfo a")
public class GcsDeviceInfo implements Serializable{
    @Id
    @Column(unique = true, nullable = false,columnDefinition = "varchar(32) comment 'IMEI 唯一' ")
    private String imei;
    @Column(columnDefinition = "varchar(16) comment '手机号' ")
    private String phone;
    @Column(columnDefinition = "varchar(64) comment '硬件信息' ")
    private String hardware;
    @Column(columnDefinition = "varchar(128) comment '用户UA' ")
    private String userAgent;
    @Column(columnDefinition = "varchar(32) comment 'wifi名称' ")
    private String wifiname;
    //    @JsonIgnoreProperties(ignoreUnknown = true)
    @Column(columnDefinition = "varchar(16) comment 'cpu处理器2' ")
   // @JsonProperty("cpu_abi2")
    private String cpuAbi2;
    @Column(columnDefinition = "varchar(8) comment 'SDK版本号' ")
    private String sdkInt;
    @Column(columnDefinition = "varchar(16) comment 'AndroidID' ")
    private String androidId;
    @Column(columnDefinition = "varchar(32) comment 'ICCID' ")
    private String iccid;
    @Column(columnDefinition = "varchar(32) comment 'MAC地址' ")
    private String mac;
    @Column(columnDefinition = "varchar(64) comment '指纹' ")
    private String fingerprint;
    @Column(columnDefinition = "varchar(64) comment '蓝牙' ")
    private String bluetouth;
    @Column(columnDefinition = "varchar(64) comment '系统类型' ")
    private String opType;
    @Column(columnDefinition = "varchar(64) comment '' ")
    private String bootloader;
    @Column(columnDefinition = "varchar(64) comment '' ")
    private String display;
    @Column(columnDefinition = "varchar(64) comment '品牌' ")
    private String board;
    @Column(columnDefinition = "varchar(16) comment '系统类型' ")
    private String dayTime;
    @Column(columnDefinition = "varchar(32) comment '产品' ")
    private String product;
    @Column(columnDefinition = "varchar(32) comment 'cpu型号' ")
    private String cpumodel;
    //@JsonProperty("cpu_abi2")
    @Column(columnDefinition = "varchar(32) comment 'cpu处理器' ")
    private String cpuAbi;
    @Column(columnDefinition = "varchar(32) comment 'ram存储容量' ")
    private String ram;
    @Column(columnDefinition = "varchar(32) comment '生产商' ")
    private String manufacturer;
    @Column(columnDefinition = "varchar(32) comment '' ")
    private String device;
    @Column(columnDefinition = "varchar(128) comment '系统UA' ")
    private String ua;
    @Column(columnDefinition = "varchar(64) comment '品牌' ")
    private String brand;
    @Column(columnDefinition = "varchar(128) comment '' ")
    private String incremental;
    @Column(columnDefinition = "varchar(64) comment '客户端IP（无用字段）' ")
    private String clientIp;
    @Column(columnDefinition = "varchar(32) comment 'IMSI' ")
    private String imsi;
    @Column(columnDefinition = "varchar(32) comment '系列号' ")
    private String serial;
    @Column(columnDefinition = "varchar(32) comment 'cellid' ")
    private String cellid;
    @Column(columnDefinition = "varchar(32) comment 'lac' ")
    private String lac;
    @Column(columnDefinition = "varchar(8) comment '宽度' ")
    private String width;
    @Column(columnDefinition = "varchar(8) comment '高度' ")
    private String height;
    @Column(columnDefinition = "varchar(8) comment 'dpi' ")
    private String dpi;


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

    public String getCellid() {
        return cellid;
    }

    public void setCellid(String cellid) {
        this.cellid = cellid;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
}
