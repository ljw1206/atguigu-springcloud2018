package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {
	
	@Bean
	public IRule myRule() {
		//return new RandomRule();  //默认是轮询，自定义是随机
        return new FiveTimesRoundRobinRule(); // 自定义为每台机器5次
	}

}
