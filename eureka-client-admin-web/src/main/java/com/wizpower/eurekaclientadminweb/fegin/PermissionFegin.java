package com.wizpower.eurekaclientadminweb.fegin;

import com.wizpower.eurekaclientadminweb.bean.po.Permission;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient("eureka-client-admin-service")
public interface PermissionFegin {
    @RequestMapping(value = "/permissionList",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity listPermissionWithParName(@RequestBody Permission permission, @RequestParam(value="pn",defaultValue = "1")Integer pn, @RequestParam(value="pageSize",defaultValue = "10")Integer pageSize);


    @RequestMapping(value = "/listPermission",method = RequestMethod.GET)
    ResponseEntity listPermission(@SpringQueryMap Permission permission);

    @RequestMapping(value = "/permission-view",method = RequestMethod.GET)
    ResponseEntity listPermissionView();

    @RequestMapping(value = "/permission",method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity addOrEditPermission(@RequestBody Permission permission);

    @RequestMapping(value = "/permission/{permissionId}",method = RequestMethod.DELETE)
    ResponseEntity deletePermission(@PathVariable("permissionId")Integer permissionId);

    @RequestMapping(value = "permission/{permissionId}",method = RequestMethod.GET)
    ResponseEntity getPermission(@PathVariable("permissionId")Integer permissionId);
}
