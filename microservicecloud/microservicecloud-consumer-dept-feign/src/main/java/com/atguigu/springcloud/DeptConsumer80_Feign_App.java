package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
  * 
  * @function 部门服务消费启动类(Feign)
  * @author Liangjw
  * @date 2021年7月18日下午4:25:38
  * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.atguigu.springcloud"})
@ComponentScan("com.atguigu.springcloud")
public class DeptConsumer80_Feign_App {

	public static void main(String[] args) {
		
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);

	}

}
