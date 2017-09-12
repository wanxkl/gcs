package com.learning.gcs.web;

import com.learning.gcs.common.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class Application {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        Test test = new Test();
        test.setName("Hello World!");
        return test.getName();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
