package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "BlackList")
@NamedQuery(name = "BlackList",query = "select a from BlackList a ")
@Entity
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable =false, columnDefinition = " int(16) COMMENT '黑名单id'")
    private int id;
    @Column(nullable = false,columnDefinition = "varchar(32) COMMENT '包名'")
    private String blackName;
    private Date createTime = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlackName() {
        return blackName;
    }

    public void setBlackName(String blackName) {
        this.blackName = blackName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
