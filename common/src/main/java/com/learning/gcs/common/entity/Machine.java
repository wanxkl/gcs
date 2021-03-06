package com.learning.gcs.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Machine")
@NamedQuery(name = "Machine", query = "SELECT a FROM Machine a")
@JsonIgnoreProperties({ "machineGroups","hibernateLazyInitializer" })
public class Machine implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer      id;
    @Column(nullable = false,columnDefinition = "varchar(16) comment '机器代码 asoId' ")
    private String       machineName;
    @Column(nullable = false,columnDefinition = "int(8) comment '生存状态 0：死亡 1：生存 2 :任务暂停' ")
    private Integer      liveStatus;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "machinesList")
    private List<MachineGroup> machineGroups;
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


    public List<MachineGroup> getMachineGroups() {
        return machineGroups;
    }

    public void setMachineGroups(List<MachineGroup> machineGroups) {
        this.machineGroups = machineGroups;
    }
}
