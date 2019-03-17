package com.wizpower.eurekaclientadminweb.web.controller;

import brave.Span;
import brave.Tracer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wizpower.eurekaclientadminweb.fegin.CoreFegin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CoreController {
    private static Logger logger= LoggerFactory.getLogger(CoreController.class);
    @Autowired
    private CoreFegin coreFegin;
    @Autowired
    private Tracer tracer;

    @GetMapping("/index")
    public String index(){
        Span span = tracer.nextSpan().name("login-index").start();
        logger.info("请求登录eureka-client-admin-web页面");
        logger.error("访问登录页面,手动增加error测试");
        try {
            return coreFegin.index();
        }catch (RuntimeException | Error e){
            span.error(e);
            throw e;
        }finally {
            span.tag("eureka-client-version","1.1.0");
            span.finish();
            logger.info("span标签增加");
        }

    }


    @GetMapping("/page/{page}")
    public String jump(@PathVariable("page")String page) {
        return coreFegin.jump(page);
    }
}
