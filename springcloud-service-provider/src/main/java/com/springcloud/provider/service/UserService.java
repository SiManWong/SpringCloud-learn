package com.springcloud.provider.service;

import com.springcloud.provider.mapper.UserMapper;
import com.springcloud.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SiMan
 * @date 2020/7/14 1:27
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public User queryUserById(String id) {
		return this.userMapper.selectByPrimaryKey(id);
	}
}
