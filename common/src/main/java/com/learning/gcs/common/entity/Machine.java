package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Machine")
@NamedQuery(name = "Machine", query = "SELECT a FROM Machine a")
public class Machine implements Serializable{

    @Id
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "varchar(16) comment '机器代码 asoId' ")
    private String machineName;
    @Column(nullable = false,columnDefinition = "int(8) comment '生存状态 0：死亡 1：生存 2 :任务暂停' ")
    private Integer liveStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Integer getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }
}
