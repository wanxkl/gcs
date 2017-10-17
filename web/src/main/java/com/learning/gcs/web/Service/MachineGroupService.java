package com.learning.gcs.web.Service;

import com.learning.gcs.common.entity.MachineGroup;

import java.util.List;

public interface MachineGroupService {
    /**
     * 返回所有分组
     * @return
     */
    List<MachineGroup> findAll();

    /**
     * 添加分组
     * @param groupName
     * @param ids
     */
    void addGroup(String groupName,String [] ids);
    /**
     * 删除设备
     * @param id
     */
    void deleteGroupMachine(int id);

    /**
     *删除组内的设备
     * @param machineId 设备id groupId 分组id
     */
    void deleteMachineGroup(int groupId,int machineId);
}
