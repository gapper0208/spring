package com.woniuxy.o_javaconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class AppTest {
	
	@Test
	public void test() throws Exception {
		
		ApplicationContext ctx = //
				new AnnotationConfigApplicationContext(RootConfig.class);
		
//		User u = (User) ctx.getBean("u4");
//		System.out.println(u);
//		System.out.println(u.getCar());
		
//		Car c = (Car) ctx.getBean("c3");
//		System.out.println(c);
		
		User u = (User) ctx.getBean("u");
		User u2 = (User) ctx.getBean("u");
		
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u == u2);
		
	}
}