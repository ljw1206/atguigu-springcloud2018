package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;

/**
  * 
  * @function 部门服务消费启动类
  * @author Liangjw
  * @date 2021年7月18日下午4:25:38
  * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class) // 在启动该微服务（MICROSERVICECLOUD-DEPT）时，使用自定义的Ribbon规则配置类MySelfRule
public class DeptConsumer80_App {

	public static void main(String[] args) {
		
		SpringApplication.run(DeptConsumer80_App.class, args);

	}

}
