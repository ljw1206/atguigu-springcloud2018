package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
  * 
  * @function 部门服务启动类
  * @author Liangjw
  * @date 2021年7月17日下午3:58:20
  * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient //启动eureka客户端功能，微服务provider启动后将自动注册进入eureka服务中
@EnableDiscoveryClient  //启动服务发现功能
public class DeptProvider8001_App {

	public static void main(String[] args) {

		SpringApplication.run(DeptProvider8001_App.class, args);
	}

}
