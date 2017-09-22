package com.learning.gcs.web;

import com.learning.gcs.common.repository.MyRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.learning.gcs.common.repository",
        repositoryBaseClass = MyRepositoryImpl.class
)
@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "com.learning.gcs.common.entity")
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Project Begin");
    }


}
