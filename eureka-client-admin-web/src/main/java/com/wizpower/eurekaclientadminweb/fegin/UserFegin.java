package com.wizpower.eurekaclientadminweb.fegin;

import com.wizpower.eurekaclientadminweb.bean.po.User;
import com.wizpower.eurekaclientadminweb.bean.po.UserRole;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@Component
@FeignClient(value = "eureka-client-admin-service",configuration = FeignConfig.class,fallback = UserHystrix.class)
public interface UserFegin {
    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity login(@RequestBody User user);
    @RequestMapping(value = "/userList",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity listUser(@RequestBody User user, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize);
    @RequestMapping(value = "/user",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity addOrEditUser(@RequestBody User user);
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.DELETE)
    ResponseEntity deleteUser(@PathVariable("userId")Integer userId);
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    ResponseEntity getUser(@PathVariable("userId")Integer userId);
    @RequestMapping(value = "/listUserRoles",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity listUserRoles(@RequestBody UserRole userRole);
}
