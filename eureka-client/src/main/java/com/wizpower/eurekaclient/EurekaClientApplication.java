package com.wizpower.eurekaclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan(value="com.wizpower.eurekaclient.dao")
@SpringBootApplication
public class EurekaClientApplication {

	/*@Autowired
	private ServiceConfig serviceConfig;*/

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}

