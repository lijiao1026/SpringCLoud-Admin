package com.wizpower.eurekaclientadminweb.fegin;

import com.wizpower.eurekaclientadminweb.bean.po.User;
import com.wizpower.eurekaclientadminweb.bean.po.UserRole;
import com.wizpower.eurekaclientadminweb.util.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserHystrix implements UserFegin{

    @Override
    public ResponseEntity login(User user) {
        return ResponseEntity.error("Hystrix 返回出错");
    }

    @Override
    public ResponseEntity listUser(User user, Integer pn, Integer pageSize) {
        return ResponseEntity.error("Hystrix 返回出错");
    }

    @Override
    public ResponseEntity addOrEditUser(User user) {
        return ResponseEntity.error("Hystrix 返回出错");
    }

    @Override
    public ResponseEntity deleteUser(Integer userId) {
        return ResponseEntity.error("Hystrix 返回出错");
    }

    @Override
    public ResponseEntity getUser(Integer userId) {
        return ResponseEntity.error("Hystrix 返回出错");
    }

    @Override
    public ResponseEntity listUserRoles(UserRole userRole) {
        return ResponseEntity.error("Hystrix 返回出错");
    }
}
