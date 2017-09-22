package com.learning.gcs.gateway;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.gcs.common.repository.MyRepositoryFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.learning.gcs.common.repository",
        repositoryFactoryBeanClass= MyRepositoryFactoryBean.class
)
@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "com.learning.gcs.common")
public class Application  extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Project Begin");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }
}
