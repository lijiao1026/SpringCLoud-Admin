package com.wizpower.eurekaclientadminweb.web.controller;

import com.wizpower.eurekaclientadminweb.bean.po.Role;
import com.wizpower.eurekaclientadminweb.fegin.RoleFegin;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class RoleController {
    @Autowired
    private RoleFegin roleFegin;
    @PostMapping("/roleList")
    public ResponseEntity listRole(Role role, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize, @RequestParam(value="notAllowPage",defaultValue ="0") Integer notAllowPage){
        return  roleFegin.listRole(role,pn,pageSize,notAllowPage);
    }
    @PostMapping("/role")
    public ResponseEntity addOrEditRole(Role role){
        return  roleFegin.addOrEditRole(role);
    }
    @DeleteMapping("/role/{roleId}")
    public ResponseEntity deleteRole(@PathVariable("roleId")Integer roleId){
        return roleFegin.deleteRole(roleId);
    }
    @GetMapping("/role/{roleId}")
    public ResponseEntity getRole(@PathVariable("roleId")Integer roleId){
        return roleFegin.getRole(roleId);
    }
    @GetMapping("/role-permission/{roleId}")
    public ResponseEntity getRolePermission(@PathVariable("roleId")Integer roleId){
        return  roleFegin.getRolePermission(roleId);
    }
    @PostMapping(value = "/role-authorization/{roleId}")
    public ResponseEntity RoleAuthorization(@PathVariable("roleId")Integer roleId,@RequestParam("permissionIds[]") Integer[] permissionIds){
        return  roleFegin.RoleAuthorization(roleId,permissionIds);
    }
}
