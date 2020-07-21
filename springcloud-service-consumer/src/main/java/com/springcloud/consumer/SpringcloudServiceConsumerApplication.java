package com.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringCloudApplication	// 组合注解 相当于@SpringBootApplication @EnableDiscoveryClient @EnableCircuitBreaker
@EnableFeignClients	// 开启Feign功能
public class SpringcloudServiceConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceConsumerApplication.class, args);
	}
}
