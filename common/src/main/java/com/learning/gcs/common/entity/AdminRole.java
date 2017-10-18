package com.learning.gcs.common.entity;

import javax.persistence.*;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/9/18 11:21
 * @description
 */
@Entity
@Table(name = "AdminRole")
@NamedQuery(name = "AdminRole", query = "SELECT a FROM AdminRole a")
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "varchar(32) COMMENT '权限名称'")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}