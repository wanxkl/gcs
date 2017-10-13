package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/13 10:19
 * @description
 */
@Entity
@Table(name = "GcsTaskPhoneCaptchaChannel")
@NamedQuery(name = "GcsTaskPhoneCaptchaChannel", query = "SELECT a FROM GcsTaskPhoneCaptchaChannel a")
public class GcsTaskPhoneCaptchaChannel implements Serializable{
    private static final long serialVersionUID = -7511102355739388755L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer id;
    @Column(nullable = false,columnDefinition = "int(11) comment 'taskId' ")
    private Integer gcsTaskId;
    @Column(nullable = false,columnDefinition = "int(11) comment '渠道Id' ")
    private Integer phoneCaptchaChannelId;
    @Column(nullable = false,columnDefinition = "varchar(32) comment '任务对应的渠道项目Id' ")
    private String  phoneCaptchaChannelProjectId;
    @Column(nullable = false,columnDefinition = "int(11) comment '权重' ")
    private Integer weight;
    @Column(nullable = false,columnDefinition = "int(11) comment '状态：0:停用 1:启用' ")
    private Integer status;

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

    public String getPhoneCaptchaChannelProjectId() {
        return phoneCaptchaChannelProjectId;
    }

    public void setPhoneCaptchaChannelProjectId(String phoneCaptchaChannelProjectId) {
        this.phoneCaptchaChannelProjectId = phoneCaptchaChannelProjectId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
