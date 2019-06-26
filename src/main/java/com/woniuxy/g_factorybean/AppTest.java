package com.woniuxy.g_factorybean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
 BeanFactory和FactoryBean的区别
 1. BeanFactory是一个spring ioc容器； FactoryBean只是一个bean。
 2. 如果spring ioc容器管理的bean，所属的类实现了FactoryBean接口，则spring ioc容器是不会直接把该类本身的实例存入容器中
    而是把该类的getObject方法返回的对象存入容器中。 
 3. 如果在实现了FactoryBean的前提之下，还想获取当前类本身，则在获取bean的时候，在bean的名字前加上“&”即可
*/

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/g_factorybean/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");
		System.out.println(u.getClass());
		
		// Object obj = new UserFactory();
		Object obj = ctx.getBean("uf");
		System.out.println(obj.getClass());
		
		Object obj2 = ctx.getBean("uf");
		System.out.println(obj.getClass());
		
		System.out.println(obj == obj2);
		
		Class clazz  = ctx.getType("uf");
		System.out.println(clazz + "~~~");
	}
}
