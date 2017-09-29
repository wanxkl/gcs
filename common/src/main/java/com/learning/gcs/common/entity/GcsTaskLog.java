package com.learning.gcs.common.entity;

import com.learning.gcs.common.util.TimeUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GcsTaskLog")
@NamedQuery(name = "GcsTaskLog", query = "SELECT a FROM GcsTaskLog a")
public class GcsTaskLog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "int(11) comment '任务ID' ")
    private Integer taskId;
    @Column(nullable = false,columnDefinition = "varchar(32) comment 'IMEI' ")
    private String imei;
    @Column(nullable = false,columnDefinition = "varchar(32) comment '留存标示' ")
    private Integer rt = 1;
    @Column(columnDefinition = "varchar(32) comment '用户名' ")
    private String userName;
    @Column(columnDefinition = "varchar(32) comment '用户密码' ")
    private String userPassword;
    @Column(columnDefinition = "varchar(32) comment '上次所用ip' ")
    private String ip;
    @Column(nullable = false,columnDefinition = "int(8) comment '日志状态：0 正常  1:锁定' ")
    private Integer logStatus;
    @Column(nullable = false,columnDefinition = "int(8) comment '日活跃次数' ")
    private Integer dailyActiveTimes;
    private Date createTime = new Date();
    @Column(columnDefinition = "varchar(16) comment '创建日期' ")
    private String createDate = TimeUtil.getFormatDate();
    @Column(columnDefinition = "varchar(64) comment '任务名称' ")
    private String taskName;
    @Column(columnDefinition = "varchar(32) comment '设备Id' ")
    private String deviceId;
    @Column(columnDefinition = "int(11) comment '脚本版本' ")
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getRt() {
        return rt;
    }

    public void setRt(Integer rt) {
        this.rt = rt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public Integer getDailyActiveTimes() {
        return dailyActiveTimes;
    }

    public void setDailyActiveTimes(Integer dailyActiveTimes) {
        this.dailyActiveTimes = dailyActiveTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
