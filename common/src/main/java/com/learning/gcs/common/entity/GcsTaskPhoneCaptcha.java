package com.learning.gcs.common.entity;

import javax.persistence.*;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/12 16:57
 * @description
 */
@Entity
@Table(name = "GcsTaskPhoneCaptcha")
@NamedQuery(name = "GcsTaskPhoneCaptcha", query = "SELECT a FROM GcsTaskPhoneCaptcha a")
public class GcsTaskPhoneCaptcha {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer   id;
    @Column(nullable = false,columnDefinition = "int(11) comment '任务ID' ")
    private Integer gcsTaskId;
    @Column(nullable = false,columnDefinition = "int(11) comment '手机验证码ID' ")
    private Integer phoneCaptchaId;

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

    public Integer getPhoneCaptchaId() {
        return phoneCaptchaId;
    }

    public void setPhoneCaptchaId(Integer phoneCaptchaId) {
        this.phoneCaptchaId = phoneCaptchaId;
    }
}
