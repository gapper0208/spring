package com.woniuxy.h_createbean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/h_createbean/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");
		System.out.println(u);
		
		User u2 = (User) ctx.getBean("u2");
		System.out.println(u2);
		
		User u3 = (User) ctx.getBean("u3");
		System.out.println(u3);
	}
}
