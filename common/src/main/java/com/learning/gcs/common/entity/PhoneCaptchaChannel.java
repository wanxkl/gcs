package com.learning.gcs.common.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/13 10:09
 * @description
 */
@Entity
@Table(name = "PhoneCaptchaChannel")
@NamedQuery(name = "PhoneCaptchaChannel", query = "SELECT a FROM PhoneCaptchaChannel a")
public class PhoneCaptchaChannel implements Serializable{
    private static final long serialVersionUID = -3491611129847271443L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false,columnDefinition = "int(11) comment '主键ID,机器号' ")
    private Integer   id;
    @Column(nullable = false,columnDefinition = "varchar(32) comment '验证码平台名称' ")
    private String channelName;
    @Column(nullable = false,columnDefinition = "varchar(32) comment '验证码平台网址' ")
    private String channelSite;
    @Column(nullable = false,columnDefinition = "varchar(32) comment '验证码平台service实现类' ")
    private String channelService;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelSite() {
        return channelSite;
    }

    public void setChannelSite(String channelSite) {
        this.channelSite = channelSite;
    }

    public String getChannelService() {
        return channelService;
    }

    public void setChannelService(String channelService) {
        this.channelService = channelService;
    }
}
