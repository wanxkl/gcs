package com.learning.gcs.web.Service;

import com.learning.gcs.common.entity.Machine;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MachineService {
    /**
     * 查询所有设备
     * @return 设备集合
     */
    List<Machine> findAll();

    /**
     * 设备分页查询
     * @param pageSize 每页个数
     * @param pageNo 页码
     * @return
     */
    Page<Machine> findByPage(int pageSize, int pageNo);

    /**
     *
     * @param machineName
     * @param liveState
     */
    void addMachine(String machineName,int liveState);

    /**
     * 删除设备
     * @param id
     */
    void deleteMachine(int id);
    /**
     * 修改设备
     */
    void updateMachine(int id,String machineName,int livaState);
}
