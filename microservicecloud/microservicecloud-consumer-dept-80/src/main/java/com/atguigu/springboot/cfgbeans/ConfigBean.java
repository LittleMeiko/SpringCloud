package com.atguigu.springboot.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	
	@Bean
	// Spring Cloud Ribbon是基于Netlix Ribbon实现的一套客户端负载均衡的工具
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		// return new RoundRobinRule();
		return new RandomRule(); // 用随机算法替换默认的轮询算法
	}
}
