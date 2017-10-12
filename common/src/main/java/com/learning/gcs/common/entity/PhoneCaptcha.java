package com.learning.gcs.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 16:22
 * @description
 */
@Entity
@Table(name = "PhoneCaptcha")
@NamedQuery(name = "PhoneCaptcha", query = "SELECT a FROM PhoneCaptcha a")
public class PhoneCaptcha implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer   id;
    @Column(nullable = false,columnDefinition = "varchar(16) comment '手机号' ")
    @JsonProperty("mobile")
    private String phoneNumber;
    @Column(nullable = false,columnDefinition = "varchar(32) comment 'IMSI' ")
    private String imsi;
    @Column(nullable = false,columnDefinition = "int(8) comment '运营商 0移动、1电信、2联通' ")
    @JsonProperty("optype")
    private Integer opType;
    @Column(columnDefinition = "varchar(16) comment '验证码' ")
    private String captcha;

    private Date createTime = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }
}
