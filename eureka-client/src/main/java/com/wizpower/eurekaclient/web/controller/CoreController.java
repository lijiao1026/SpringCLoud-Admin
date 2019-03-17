package com.wizpower.eurekaclient.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {
    private static Logger logger= LoggerFactory.getLogger(CoreController.class);
    @GetMapping("/index")
    public String index(){
        logger.info("请求登录eureka-client页面");
        return "login";
    }


    @GetMapping("/page/{page}")
    public String jump(@PathVariable("page")String page) {
        return page;
    }
}
