package com.learning.gcs.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/9/13 1:21
 * @description
 */
@Entity
@Table(name = "AdminUser")
@NamedQuery(name = "AdminUser", query = "SELECT a FROM AdminUser a")
public class AdminUser extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1660836200116410830L;
    @Column(nullable = false, length = 32)
    private String userName;
    @Column(nullable = false, length = 32)
    private String password;
    private Integer userType;
    private Integer userLevel;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
}
