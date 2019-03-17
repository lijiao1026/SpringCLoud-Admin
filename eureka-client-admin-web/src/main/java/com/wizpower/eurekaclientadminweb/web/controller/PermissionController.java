package com.wizpower.eurekaclientadminweb.web.controller;

import com.wizpower.eurekaclientadminweb.bean.po.Permission;
import com.wizpower.eurekaclientadminweb.fegin.PermissionFegin;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermissionController {
    @Autowired
    PermissionFegin permissionFegin;
    @PostMapping("/permissionList")
     public ResponseEntity listPermissionWithParName(Permission permission, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize){
        return  permissionFegin.listPermissionWithParName(permission,pn,pageSize);
    }

    @GetMapping("/listPermission")
    public ResponseEntity listPermission(Permission permission){
         return permissionFegin.listPermission(permission);
    }

    @GetMapping("/permission-view")
    public ResponseEntity listPermissionView(){
        return  permissionFegin.listPermissionView();
    }

    @PostMapping("/permission")
    public ResponseEntity addOrEditPermission(Permission permission){
        return  permissionFegin.addOrEditPermission(permission);
    }

    @DeleteMapping("/permission/{permissionId}")
    public ResponseEntity deletePermission(@PathVariable("permissionId")Integer permissionId){
        return  permissionFegin.deletePermission(permissionId);
    }

    @GetMapping("/permission/{permissionId}")
    public ResponseEntity getPermission(@PathVariable("permissionId")Integer permissionId){
        return  permissionFegin.getPermission(permissionId);
    }
}
