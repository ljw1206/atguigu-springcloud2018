package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

/**
  * 
  * @function 部门服务消费者
  * @author Liangjw
  * @date 2021年7月18日下午4:10:13
  * @since JDK 1.8
 */
@RestController
public class DeptController_Consumer {
	
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		System.out.println("消费者查询Dept,id: " + id);
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		System.out.println("消费者查询所有Dept列表");
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		System.out.println("消费者添加一个Dept: " + dept);
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        System.out.println("消费者调用服务发现");
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
