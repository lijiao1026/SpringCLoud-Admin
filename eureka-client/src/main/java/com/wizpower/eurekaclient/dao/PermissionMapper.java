package com.wizpower.eurekaclient.dao;




import com.wizpower.eurekaclient.bean.po.Permission;

import java.util.List;

public interface PermissionMapper {

    int deleteByPrimaryKey(Integer permissionId);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    List<Permission> listPermissionWithParName(Permission permission);

    List<Permission> listPermission(Permission permission);

    List<Permission> listPermissionView();

    List<Permission> getUserpermissions(Integer userId);
}