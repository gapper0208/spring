package com.woniuxy.i_scope;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class AppTest {
	// 测试scope
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/i_scope/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");
		User u2 = (User) ctx.getBean("u");
		User u3 = (User) ctx.getBean("u");
		
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u3);
		
		System.out.println(u == u2);
		System.out.println(u == u3); 
		System.out.println(u2 == u3);
	}
	
	
	// 测试省略了bean的id时，如何获取bean
	@Test
	public void test2() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/i_scope/applicationContext.xml");
		
		User u = (User) ctx.getBean("com.woniuxy.i_scope.User#0");
		User u2 = (User) ctx.getBean("com.woniuxy.i_scope.User#1");
		
		System.out.println(u);
		System.out.println(u2);
		
	}
	
	// 测试根据bean的类型获取bean
	@Test
	public void test3() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/i_scope/applicationContext.xml");
		
		User u = ctx.getBean(User.class);
		System.out.println(u);
	}
}
