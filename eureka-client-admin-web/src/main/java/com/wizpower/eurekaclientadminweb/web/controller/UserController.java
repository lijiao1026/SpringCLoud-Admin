package com.wizpower.eurekaclientadminweb.web.controller;

import com.wizpower.eurekaclientadminweb.bean.po.User;
import com.wizpower.eurekaclientadminweb.bean.po.UserRole;
import com.wizpower.eurekaclientadminweb.fegin.UserFegin;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserFegin userFegin;
    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(User user){
        return  userFegin.login(user);
    }
    @PostMapping("/userList")
    public ResponseEntity listUser(User user, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize){
        return  userFegin.listUser(user,pn,pageSize);
    }
    @PostMapping("/user")
    public ResponseEntity addOrEditUser(User user){
        return  userFegin.addOrEditUser(user);
    }
    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId")Integer userId){
        return  userFegin.deleteUser(userId);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity getUser(@PathVariable("userId")Integer userId){
        return  userFegin.getUser(userId);
    }
    @PostMapping("/listUserRoles")
    public ResponseEntity listUserRoles(UserRole userRole){
        return  userFegin.listUserRoles(userRole);
    }
}
