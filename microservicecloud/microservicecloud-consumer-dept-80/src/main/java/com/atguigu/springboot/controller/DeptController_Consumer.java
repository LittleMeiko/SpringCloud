package com.atguigu.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	// private static String REQUEST_URL_PREFIX = "http://localhost:8001";
	private static String REQUEST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return restTemplate.postForObject(REQUEST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable(value = "id") long id) {
		return restTemplate.getForObject(REQUEST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REQUEST_URL_PREFIX + "/dept/list", List.class);
	}
	
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REQUEST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
