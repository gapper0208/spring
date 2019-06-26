package com.woniuxy.o_javaconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 	<context:component-scan base-package="com.woniuxy.o_javaconfig2" />
 	@ComponentScan可以省略basePackages属性，如果省略，则默认会扫描当前类所在的包及其子包
*/
@Configuration
@ComponentScan(basePackages = {"com.woniuxy.o_javaconfig2"})
public class RootConfig {
	
	@Bean
	public Car c() {
		Car c = new Car();
		c.setBrand("法拉利");
		c.setColor("红色");
		return c;
	}
}