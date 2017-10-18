package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/18 10:08
 * @description 任务总览
 */
@Entity
@Table(name = "GcsTaskOverview")
@NamedQuery(name = "GcsTaskOverview", query = "SELECT a FROM GcsTaskOverview a")
public class GcsTaskOverview implements Serializable{
    private static final long serialVersionUID = -8141860388537181331L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,任务总览ID' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "int(11) comment '任务类型Id' ")
    private Integer taskId;
    @Column(nullable = false,columnDefinition = "varchar(64) COMMENT '任务类型名称'")
    private String taskName;
    @Column(nullable = false,columnDefinition = "int(11) comment '任务计划数' ")
    private Integer planCount;
    @Column(nullable = false,columnDefinition = "int(11) comment '任务完成数' ")
    private Integer doneCount;
    @Column(nullable = false,columnDefinition = "varchar(32) COMMENT '任务日期'")
    private String createDate;
    private Date createTime = new Date();


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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getPlanCount() {
        return planCount;
    }

    public void setPlanCount(Integer planCount) {
        this.planCount = planCount;
    }

    public Integer getDoneCount() {
        return doneCount;
    }

    public void setDoneCount(Integer doneCount) {
        this.doneCount = doneCount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
