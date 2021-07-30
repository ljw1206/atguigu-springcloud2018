package com.atguigu.springcloud.service;

import java.util.List;

import com.atguigu.springcloud.entities.Dept;

/**
  * 
  * @function 部门接口服务层 
  * @author Liangjw
  * @date 2021年7月17日下午3:22:10
  * @since JDK 1.8
 */
public interface DeptService {

	public Dept get(Long id);

	public List<Dept> list();

	public boolean add(Dept dept);
}
