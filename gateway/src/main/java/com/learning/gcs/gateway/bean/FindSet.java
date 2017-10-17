package com.learning.gcs.gateway.bean;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/17 18:04
 * @description
 */
public class FindSet {

    private Integer findPageNumber;

    private FindSetColorAndString appIcon;

    private FindSetColorAndString appDec;

    public Integer getFindPageNumber() {
        return findPageNumber;
    }

    public void setFindPageNumber(Integer findPageNumber) {
        this.findPageNumber = findPageNumber;
    }

    public FindSetColorAndString getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(FindSetColorAndString appIcon) {
        this.appIcon = appIcon;
    }

    public FindSetColorAndString getAppDec() {
        return appDec;
    }

    public void setAppDec(FindSetColorAndString appDec) {
        this.appDec = appDec;
    }
}
