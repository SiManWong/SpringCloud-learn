package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	// 启用Eureka服务端
public class SpringcloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaApplication.class, args);
	}
}
