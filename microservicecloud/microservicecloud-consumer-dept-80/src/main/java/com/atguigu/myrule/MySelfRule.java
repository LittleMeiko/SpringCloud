package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {
	
	@Bean
	public IRule myRule() {
		return new RandomRule_ZY(); // 自定义负载均衡规则--要求每台机器被调用5次
	}
}
