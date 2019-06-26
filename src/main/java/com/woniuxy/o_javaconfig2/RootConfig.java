package com.woniuxy.o_javaconfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 	<context:component-scan base-package="com.woniuxy.o_javaconfig2" />
 	@ComponentScan����ʡ��basePackages���ԣ����ʡ�ԣ���Ĭ�ϻ�ɨ�赱ǰ�����ڵİ������Ӱ�
*/
@Configuration
@ComponentScan(basePackages = {"com.woniuxy.o_javaconfig2"})
public class RootConfig {
	
	@Bean
	public Car c() {
		Car c = new Car();
		c.setBrand("������");
		c.setColor("��ɫ");
		return c;
	}
}