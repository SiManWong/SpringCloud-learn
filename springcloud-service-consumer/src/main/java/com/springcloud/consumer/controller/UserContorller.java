package com.springcloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.consumer.client.UserClient;
import com.springcloud.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SiMan
 * @date 2020/7/14 1:53
 */
@RestController
@RequestMapping("consumer/user")
public class UserContorller {
	@Autowired
	private DiscoveryClient discoveryClient; // Eureka客户端，可以获取到服务实例信息

	@Autowired
	private UserClient userClient;

	@GetMapping
	@HystrixCommand
	public User queryUserById(@RequestParam("id") String id) {
		return userClient.queryUserById(id);
	}
}
