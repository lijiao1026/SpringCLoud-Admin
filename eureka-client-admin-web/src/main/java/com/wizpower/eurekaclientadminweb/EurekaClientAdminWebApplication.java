package com.wizpower.eurekaclientadminweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@SpringBootApplication
public class EurekaClientAdminWebApplication {



	public static void main(String[] args) {
		SpringApplication.run(EurekaClientAdminWebApplication.class, args);
	}

}

