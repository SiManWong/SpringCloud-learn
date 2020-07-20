package com.springcloud.provider.controller;

import com.springcloud.provider.pojo.User;
import com.springcloud.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author SiMan
 * @date 2020/7/14 1:29
 */
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public User queryUserById(@PathVariable("id") String id) {
		return this.userService.queryUserById(id);
	}
}
