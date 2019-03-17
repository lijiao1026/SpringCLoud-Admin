package com.wizpower.eurekaclient.dao;



import com.wizpower.eurekaclient.bean.po.User;

import java.util.List;


public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    List<User> listUser(User record);
}