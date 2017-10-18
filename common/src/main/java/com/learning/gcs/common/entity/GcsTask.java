package com.learning.gcs.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.repository.query.parser.Part;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "GcsTask")
@NamedQuery(name = "GcsTask", query = "SELECT a FROM GcsTask a")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GcsTask implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID' ")
    private Integer id;

    @Column(nullable = false,columnDefinition = "varchar(32) COMMENT '任务名称'")
    private String appName;

    @Column(nullable = false,columnDefinition = "varchar(64) COMMENT '任务APK下载地址'")
    private String apkUrl;

    @Column(nullable = false,columnDefinition = "int(8) COMMENT '任务重试次数'")
    private Integer runNumber;

    @Column(nullable = false,columnDefinition = "int(8) COMMENT '权重：1-10'")
    private Integer weight;

    @Column(nullable = false,columnDefinition = "int(8) COMMENT '任务类型编码'")
    private Integer taskModeCode;

    @Column(nullable = false,columnDefinition = "varchar(64) COMMENT '任务类型名称'")
    private String taskMode;

    @Column(columnDefinition = "varchar(32) COMMENT '任务包名(taskMode=cpa时不为空)'")
    private String packageName;

    @Column(columnDefinition = "varchar(64) COMMENT '市场名字（taskMode=market时不为空)'")
    private String marketName;

    @Column(columnDefinition = "varchar(128) COMMENT '市场URL（taskMode=market时不为空)'")
    private String marketUrl;

    @Column(columnDefinition = "varchar(128) COMMENT '市场包名（taskMode=market时不为空)'")
    private String marketPackName;

    @Column(columnDefinition = "varchar(64) COMMENT '搜索关键字（taskMode=market时不为空)'")
    private String searchTxt;

    @Column(columnDefinition = "varchar(1024) COMMENT '脚本辅助信息（taskMode=market时不为空)'")
    private String findSet;

    @Column(nullable = false,columnDefinition = "int(8) COMMENT '任务状态 0：暂停 1：启用 '")
    private Integer taskStatus;
    @Column(nullable = false,columnDefinition = "int(8) COMMENT '任务数量'")
    private Integer      taskCount;
    @Column(columnDefinition = "varchar(1024) COMMENT '任务机器ID 空值为全部 '")
    private String       machineIds;
    @Column(nullable = false,columnDefinition = "int(8) COMMENT '新增留存曲线ID'")
    private Integer      newAddRemainCurveId;
    @Column(nullable = false,columnDefinition = "int(8) COMMENT '日常留存曲线ID'")
    private Integer      nichijouRemainCurveId;
    @Column(nullable = false,columnDefinition = "int(8) COMMENT '月留存曲线ID'")
    private Integer      remainCurveId;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name="groupId")
    private MachineGroup group;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public Integer getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(Integer runNumber) {
        this.runNumber = runNumber;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getTaskModeCode() {
        return taskModeCode;
    }

    public void setTaskModeCode(Integer taskModeCode) {
        this.taskModeCode = taskModeCode;
    }

    public String getTaskMode() {
        return taskMode;
    }

    public void setTaskMode(String taskMode) {
        this.taskMode = taskMode;
    }

    public String getMarketUrl() {
        return marketUrl;
    }

    public void setMarketUrl(String marketUrl) {
        this.marketUrl = marketUrl;
    }

    public String getMarketPackName() {
        return marketPackName;
    }

    public void setMarketPackName(String marketPackName) {
        this.marketPackName = marketPackName;
    }

    public String getSearchTxt() {
        return searchTxt;
    }

    public void setSearchTxt(String searchTxt) {
        this.searchTxt = searchTxt;
    }

    public String getFindSet() {
        return findSet;
    }

    public void setFindSet(String findSet) {
        this.findSet = findSet;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getMachineIds() {
        return machineIds;
    }

    public void setMachineIds(String machineIds) {
        this.machineIds = machineIds;
    }

    public Integer getNewAddRemainCurveId() {
        return newAddRemainCurveId;
    }

    public void setNewAddRemainCurveId(Integer newAddRemainCurveId) {
        this.newAddRemainCurveId = newAddRemainCurveId;
    }

    public Integer getNichijouRemainCurveId() {
        return nichijouRemainCurveId;
    }

    public void setNichijouRemainCurveId(Integer nichijouRemainCurveId) {
        this.nichijouRemainCurveId = nichijouRemainCurveId;
    }

    public Integer getRemainCurveId() {
        return remainCurveId;
    }

    public void setRemainCurveId(Integer remainCurveId) {
        this.remainCurveId = remainCurveId;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public MachineGroup getGroup() {
        return group;
    }

    public void setGroup(MachineGroup group) {
        this.group = group;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
