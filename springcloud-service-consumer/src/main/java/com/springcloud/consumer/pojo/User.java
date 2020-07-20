package com.springcloud.consumer.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author SiMan
 * @date 2020/7/14 1:11
 */


@Data
public class User {
	private String id;

	private String userName;

	private String password;

	private BigDecimal balance;

	private String role;
}
