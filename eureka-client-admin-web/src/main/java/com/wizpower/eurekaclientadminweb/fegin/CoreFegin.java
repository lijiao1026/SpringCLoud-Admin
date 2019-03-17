package com.wizpower.eurekaclientadminweb.fegin;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("eureka-client-admin-service")
@FeignClient("cloud-zuul")
public interface CoreFegin {
    //@LoadBalanced
    @GetMapping("/admin/index")
   String index();


    @GetMapping("/admin/page/{page}")
   String jump(@PathVariable("page")String page) ;
}
