package com.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient // 启用eureka客户端
@MapperScan("com.springcloud.provider.mapper")
public class SpringcloudServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceProviderApplication.class, args);
	}

}
