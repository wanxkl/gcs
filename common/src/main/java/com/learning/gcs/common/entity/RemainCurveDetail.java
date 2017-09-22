package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "RemainCurveDetail")
@NamedQuery(name = "RemainCurveDetail", query = "SELECT a FROM RemainCurveDetail a")
public class RemainCurveDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;
    @ManyToOne
    private RemainCurve remainCurve;
    @Column(nullable = false,columnDefinition = "float(8) COMMENT '比重'")
    private Float percent;
    @Column(nullable = false,columnDefinition = "int(8) COMMENT '时间距离'")
    private Integer distince;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RemainCurve getRemainCurve() {
        return remainCurve;
    }

    public void setRemainCurve(RemainCurve remainCurve) {
        this.remainCurve = remainCurve;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public Integer getDistince() {
        return distince;
    }

    public void setDistince(Integer distince) {
        this.distince = distince;
    }
}
