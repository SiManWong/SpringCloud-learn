package com.springcloud.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;

/**
 * @author SiMan
 * @date 2020/7/17 0:44
 */
@SpringBootTest
public class RibbonLoadBalanceTest {
	@Autowired
	private RibbonLoadBalancerClient client;

	@Test
	public void test() {
		for (int i = 0; i < 50; i++) {
			ServiceInstance instance = this.client.choose("service-provide");
			System.out.println(instance.getHost() + ":" + instance.getPort());
		}
	}
}
