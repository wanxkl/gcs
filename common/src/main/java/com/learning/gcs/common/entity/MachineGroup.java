package com.learning.gcs.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MachineGroup")
@NamedQuery(name="MachineGroup",query = "select a from MachineGroup a")
public class MachineGroup {
    private static final long serialVersionUID = 8663645972182394771L;
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
}
