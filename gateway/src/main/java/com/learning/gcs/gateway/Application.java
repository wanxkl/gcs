package com.learning.gcs.gateway;

import com.learning.gcs.common.repository.MyRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
