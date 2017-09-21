package com.learning.gcs.gateway.controller;

import com.learning.gcs.gateway.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("verify")
public class VerifyController {

    @RequestMapping("/ip")
    Result ip(){
        return new Result();
    }

}
