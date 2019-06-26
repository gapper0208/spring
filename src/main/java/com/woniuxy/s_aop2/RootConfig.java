package com.woniuxy.s_aop2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy  // �ȼ���xml�����е�<aop:aspectj-autoproxy />
public class RootConfig {
	
	@Bean
	public ICalc c2() {
		ICalc c = new CalcImpl();
		return c; 
	}
	

	@Bean
	public ICalc c3() {
		ICalc c = new CalcImpl();
		return c; 
	}
}
