package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
  * 
  * @function EurekaServer服务器端启动类,接受其它微服务注册进来
  * @author Liangjw
  * @date 2021年7月18日下午7:34:55
  * @since JDK 1.8
 */
@SpringBootApplication
@EnableEurekaServer   
public class EurekaServer7001_App {

	public static void main(String[] args) {
		
		SpringApplication.run(EurekaServer7001_App.class, args);
		
	}

}
