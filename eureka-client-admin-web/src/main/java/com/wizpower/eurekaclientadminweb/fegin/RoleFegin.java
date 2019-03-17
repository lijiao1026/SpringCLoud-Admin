package com.wizpower.eurekaclientadminweb.fegin;

import com.wizpower.eurekaclientadminweb.bean.po.Role;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
@FeignClient("eureka-client-admin-service")
public interface RoleFegin {
    @RequestMapping(value = "/roleList",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity listRole(@RequestBody Role role, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize, @RequestParam(value="notAllowPage",defaultValue ="0") Integer notAllowPage);

    @RequestMapping(value = "/role",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity addOrEditRole(@RequestBody Role role);
    @RequestMapping(value = "/role/{roleId}",method = RequestMethod.DELETE)
    ResponseEntity deleteRole(@PathVariable("roleId")Integer roleId);
    @RequestMapping(value = "/role/{roleId}",method = RequestMethod.GET)
    ResponseEntity getRole(@PathVariable("roleId")Integer roleId);
    @RequestMapping(value = "/role-permission/{roleId}",method = RequestMethod.GET)
    ResponseEntity getRolePermission(@PathVariable("roleId")Integer roleId);
    @RequestMapping(value = "/role-authorization/{roleId}",method = RequestMethod.POST)
    ResponseEntity RoleAuthorization(@PathVariable("roleId")Integer roleId,@RequestParam("permissionIds") Integer[] permissionIds);
}
