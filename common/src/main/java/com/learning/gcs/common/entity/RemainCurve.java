package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "RemainCurve")
@NamedQuery(name = "RemainCurve", query = "SELECT a FROM RemainCurve a")
public class RemainCurve implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false,columnDefinition = "varchar(64) COMMENT '留存名称'")
    private String remainName;
    @Column(nullable = false,columnDefinition = "varchar(64) COMMENT '留存类型 0：新增日曲线 1：留存日曲线 2：留存曲线 '")
    private Integer remainType;
    @OneToMany(mappedBy = "remainCurve",fetch = EAGER)
    private List<RemainCurveDetail> remainCurveDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemainName() {
        return remainName;
    }

    public void setRemainName(String remainName) {
        this.remainName = remainName;
    }

    public Integer getRemainType() {
        return remainType;
    }

    public void setRemainType(Integer remainType) {
        this.remainType = remainType;
    }

    public List<RemainCurveDetail> getRemainCurveDetails() {
        return remainCurveDetails;
    }

    public void setRemainCurveDetails(List<RemainCurveDetail> remainCurveDetails) {
        this.remainCurveDetails = remainCurveDetails;
    }
}
