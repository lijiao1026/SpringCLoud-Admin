package com.wizpower.eurekaclient.bean.vo;


import com.wizpower.eurekaclient.bean.po.Permission;
import com.wizpower.eurekaclient.bean.po.Role;

public class RolePermissionVO extends Role {

    private Permission permission;//角色拥有的权限

    public void setpermission(Permission permission) {
        this.permission = permission;
    }

    public Permission getpermission() {
        return permission;
    }
}
