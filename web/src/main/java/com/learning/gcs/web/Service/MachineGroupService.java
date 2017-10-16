package com.learning.gcs.web.Service;

import com.learning.gcs.common.entity.MachineGroup;

import java.util.List;

public interface MachineGroupService {
    /**
     * 返回所有分组
     * @return
     */
    List<MachineGroup> findAll();
}
