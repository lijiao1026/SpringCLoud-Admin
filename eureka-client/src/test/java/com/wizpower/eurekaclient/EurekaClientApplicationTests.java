package com.wizpower.eurekaclient;

import com.wizpower.eurekaclient.bean.po.Permission;
import com.wizpower.eurekaclient.dao.PermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EurekaClientApplicationTests {
	//@Autowired
	//private PermissionMapper permissionMapper;
	@Test
	public void contextLoads() {
		//List<Permission> permissions=permissionMapper.listPermissionView();
		//System.out.println(permissions.toString());
        System.out.println("测试");
    }

}

