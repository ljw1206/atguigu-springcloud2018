package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

/**
  * 
  * @function 部门服务消费者
  * @author Liangjw
  * @date 2021年7月18日下午4:10:13
  * @since JDK 1.8
 */
@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		System.out.println("消费者查询Dept,id: " + id);
		return this.service.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		System.out.println("消费者查询所有Dept列表");
		return this.service.list();
	}
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		System.out.println("消费者添加一个Dept: " + dept);
		return this.service.add(dept);
	}
	
}
