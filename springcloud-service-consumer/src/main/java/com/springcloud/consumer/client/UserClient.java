package com.springcloud.consumer.client;

import com.springcloud.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author SiMan
 * @date 2020/7/21 1:25
 */
@FeignClient("service-provide")
public interface UserClient {
	@GetMapping("user/{id}")
	public User queryUserById(@PathVariable("id") String id);
}
