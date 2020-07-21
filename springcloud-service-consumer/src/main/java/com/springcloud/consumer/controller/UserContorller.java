package com.springcloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient; // Eureka客户端，可以获取到服务实例信息

	@GetMapping
	@HystrixCommand
	public User queryUserById(@RequestParam("id") String id) {
		// 根据服务名称，获取服务实例
		List<ServiceInstance> instances = discoveryClient.getInstances("SERVICE-PROVIDE");
		// 因为只有一个服务,直接get(0)获取
		ServiceInstance instance = instances.get(0);
		// 获取ip和端口信息
		String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/";
//		return this.restTemplate.getForObject(baseUrl + id, User.class);
		return this.restTemplate.getForObject("http://service-provide/user/" + id, User.class);
	}

}
