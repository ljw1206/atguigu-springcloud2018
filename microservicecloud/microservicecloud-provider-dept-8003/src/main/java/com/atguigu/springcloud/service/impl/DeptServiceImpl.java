package com.atguigu.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

/**
  * 
  * @function 部门接口服务实现层
  * @author Liangjw
  * @date 2021年7月17日下午3:55:08
  * @since JDK 1.8
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao; 
	
	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

}
