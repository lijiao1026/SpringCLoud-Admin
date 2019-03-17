package com.wizpower.eurekaclientadminweb.bean.vo;


import com.wizpower.eurekaclientadminweb.bean.po.Permission;

import java.util.List;

public class PermissionView extends Permission {
    private List<Permission> childpermissions;

    public List<Permission> getChildpermissions() {
        return childpermissions;
    }

    public void setChildpermissions(List<Permission> childpermissions) {
        this.childpermissions = childpermissions;
    }
}
