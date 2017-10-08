package com.learning.gcs.gateway.service;

import com.learning.gcs.common.entity.Machine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/8 11:45
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(MachineServiceTest.class);

    @Autowired
    private MachineService machineService;

    @Test
    public void getTaskIdsByDeviceId() throws Exception {

       Set<Object> set = machineService.getTaskIdsByDeviceId("N1");

        logger.info("set size：{}",set.size());
    }

    @Test
    public void save() throws Exception {
        Machine machine  =  null;

        for (int i = 1; i <= 100; i++) {
            machine = new Machine();
            machine.setId(i);
            machine.setMachineName("N"+i);
            machine.setLiveStatus(1);
            //machineService.save(machine);
        }

    }

}