package com.learning.gcs.common.entity;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/13 15:38
 * @description
 */
@Entity
@Table(name = "GcsTaskPhoneCaptchaLog")
@NamedQuery(name = "GcsTaskPhoneCaptchaLog", query = "SELECT a FROM GcsTaskPhoneCaptchaLog a")
public class GcsTaskPhoneCaptchaLog implements Serializable{
    private static final long serialVersionUID = -1464051109144817673L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "int(11) comment 'taskId' ")
    private Integer gcsTaskId;
    @Column(nullable = false,columnDefinition = "int(11) comment '渠道Id' ")
    private Integer phoneCaptchaChannelId;
    @Column(nullable = false,columnDefinition = "varchar(32) comment '手机号' ")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(32) comment '验证码' ")
    private String captcha;

    private Date createTime = new Date();

    private Date updateTime = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGcsTaskId() {
        return gcsTaskId;
    }

    public void setGcsTaskId(Integer gcsTaskId) {
        this.gcsTaskId = gcsTaskId;
    }

    public Integer getPhoneCaptchaChannelId() {
        return phoneCaptchaChannelId;
    }

    public void setPhoneCaptchaChannelId(Integer phoneCaptchaChannelId) {
        this.phoneCaptchaChannelId = phoneCaptchaChannelId;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
