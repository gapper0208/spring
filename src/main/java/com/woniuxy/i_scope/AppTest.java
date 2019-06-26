package com.woniuxy.i_scope;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class AppTest {
	// ����scope
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
	
	
	// ����ʡ����bean��idʱ����λ�ȡbean
	@Test
	public void test2() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/i_scope/applicationContext.xml");
		
		User u = (User) ctx.getBean("com.woniuxy.i_scope.User#0");
		User u2 = (User) ctx.getBean("com.woniuxy.i_scope.User#1");
		
		System.out.println(u);
		System.out.println(u2);
		
	}
	
	// ���Ը���bean�����ͻ�ȡbean
	@Test
	public void test3() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/i_scope/applicationContext.xml");
		
		User u = ctx.getBean(User.class);
		System.out.println(u);
	}
}
