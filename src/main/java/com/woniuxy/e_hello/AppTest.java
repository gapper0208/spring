package com.woniuxy.e_hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/e_hello/applicationContext.xml");
		// <bean id="t" class="com.woniuxy.e_hello.Bear"></bean>
		Toy toy = (Toy) ctx.getBean("t"); 
		toy.play();
	}
}
