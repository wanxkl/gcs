package com.learning.gcs.gateway.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    @org.junit.Test
    public void testLog() throws Exception {
        logger.error("error");
    }
}
