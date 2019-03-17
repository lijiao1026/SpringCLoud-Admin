package com.wizpower.eurekaserver;

import com.wizpower.eurekaserver.Service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {

	@Autowired
	private MailService mailService;

	@Test
	public void contextLoads() {
		//mailService.sendSimpleMail("15365186121@163.com", "这是一个测试邮件", "这是一个测试邮件");
	}
}
