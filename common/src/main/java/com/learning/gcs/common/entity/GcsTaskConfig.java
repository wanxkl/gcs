package com.learning.gcs.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "GcsTaskConfig")
@NamedQuery(name = "GcsTaskConfig", query = "SELECT a FROM GcsTaskConfig a")
public class GcsTaskConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "int(11) comment '配置信息版本号' ")
    private Integer version;
    @Column(nullable = false,columnDefinition = "int(8) comment '重试次数' ")
    private Integer runTimeMax;
    @Column(nullable = false,columnDefinition = "varchar(128) COMMENT '脚本更新地址'")
    private String luaUrl;
    @Column(nullable = false,columnDefinition = "tinyint(1) COMMENT '配置状态 1:true 0:false'")
    private boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getRunTimeMax() {
        return runTimeMax;
    }

    public void setRunTimeMax(Integer runTimeMax) {
        this.runTimeMax = runTimeMax;
    }

    public String getLuaUrl() {
        return luaUrl;
    }

    public void setLuaUrl(String luaUrl) {
        this.luaUrl = luaUrl;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
