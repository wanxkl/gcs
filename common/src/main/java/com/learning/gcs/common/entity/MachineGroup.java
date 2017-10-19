package com.learning.gcs.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MachineGroup")
@NamedQuery(name="MachineGroup",query = "select a from MachineGroup a")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class MachineGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false,columnDefinition = "int(16) comment '主键id'")
    private int id;
    @Column(nullable = false,columnDefinition = "varchar(128) comment '组名'")
    private String groupName;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<Machine> machinesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Machine> getMachinesList() {
        return machinesList;
    }

    public void setMachines(List<Machine> machinesList) {
        this.machinesList = machinesList;
    }

    public void setMachinesList(List<Machine> machinesList) {
        this.machinesList = machinesList;
    }

    @Override
    public String toString() {
        return "id="+this.id+"-groupName="+this.groupName+"-list="+this.machinesList;
    }
}
