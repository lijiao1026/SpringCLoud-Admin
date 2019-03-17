package com.wizpower.eurekaclient.dao;




import com.wizpower.eurekaclient.bean.po.Role;

import java.util.List;

public interface RoleMapper {

    int deleteByPrimaryKey(Integer roleId);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    List<Role> listRole(Role role);
}