package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GcsTaskMode")
@NamedQuery(name = "GcsTaskMode", query = "SELECT a FROM GcsTaskMode a")
public class GcsTaskMode implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,任务类型编码' ")
    private Integer id;

    @Column(nullable = false,columnDefinition = "varchar(64) COMMENT '任务类型名称'")
    private String taskMode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskMode() {
        return taskMode;
    }

    public void setTaskMode(String taskMode) {
        this.taskMode = taskMode;
    }
}
