package com.springcloud.provider.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author SiMan
 * @date 2020/7/14 1:11
 */

@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String userName;

	private String password;

	private BigDecimal balance;

	private String role;
}
