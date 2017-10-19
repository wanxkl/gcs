package com.learning.gcs.common.bean;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/19 17:05
 * @description
 */
public class GroupBean {
    private Integer groupId;
    private String groupName;
    private Integer groupCount;

    public GroupBean() {
    }

    public GroupBean(Integer groupId, Integer groupCount) {
        this.groupId = groupId;
        this.groupCount = groupCount;
    }

    public GroupBean(String groupName, Integer groupCount) {
        this.groupName = groupName;
        this.groupCount = groupCount;
    }

    public GroupBean(Integer groupId, String groupName, Integer groupCount) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupCount = groupCount;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }
}
