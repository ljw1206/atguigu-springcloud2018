package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  * 
  * @function 部门接口
  * @author Liangjw
  * @date 2021年7月17日下午2:59:44
  * @since JDK 1.8
 */
@Mapper
public interface DeptDao {
	
	public Dept findById(Long id);

	public List<Dept> findAll();

	public boolean addDept(Dept dept);

}
