package com.wizpower.eurekaclient.service.interfaces;



import com.wizpower.eurekaclient.bean.po.User;
import com.wizpower.eurekaclient.bean.po.UserRole;

import java.util.List;

public interface UserService {

    Integer add(User user);

    Integer delete(Integer userId);

    Integer update(User user);

    List<User> listUser(User user);

    User selectByPrimaryKey(Integer userId);

    List<UserRole> listUserRoles(UserRole userRole);

}
