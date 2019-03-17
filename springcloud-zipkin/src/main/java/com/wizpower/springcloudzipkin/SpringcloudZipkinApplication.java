package com.wizpower.springcloudzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SpringcloudZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZipkinApplication.class, args);
	}

}

