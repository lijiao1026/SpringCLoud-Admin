package com.wizpower.eurekaclient.service.impl;


import com.wizpower.eurekaclient.bean.po.Role;
import com.wizpower.eurekaclient.bean.po.RolePermission;
import com.wizpower.eurekaclient.bean.vo.RolePermissionVO;
import com.wizpower.eurekaclient.dao.RoleMapper;
import com.wizpower.eurekaclient.dao.RolePermissionMapper;
import com.wizpower.eurekaclient.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissionMapper rolepermissionMapper;

    @Override
    public Integer add(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public Integer delete(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Integer update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<Role> listRole(Role role) {
        return roleMapper.listRole(role);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<RolePermission> listRolepermission(Integer roleId) {
        return rolepermissionMapper.listRolepermission(roleId);
    }

    @Override
    public List<RolePermissionVO> listRolepermissions(Integer roleId) {
        return rolepermissionMapper.listRolepermissions(roleId);
    }

    @Transactional
    @Override
    public Integer batchInsert(List<RolePermission> rolepermissions) {
        RolePermission rolepermission=rolepermissions.get(0);
        rolepermissionMapper.deleteByRoleId(rolepermission.getRoleId());
        return rolepermissionMapper.batchInsert(rolepermissions);
    }

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        return rolepermissionMapper.deleteByRoleId(roleId);
    }
}
