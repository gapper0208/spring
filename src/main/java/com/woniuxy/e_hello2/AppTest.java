package com.woniuxy.e_hello2;

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
		
		// BeanFactory有一个子接口：ApplicationContext, 也就是说，ApplicationContext具备BeanFactory的所有功能
		// ApplicationContext还有自己扩展的功能，总之ApplicationContext比BeanFactory功能更强大！
		
//		Resource src = new ClassPathResource("com/woniuxy/e_hello2/applicationContext.xml");
//		BeanFactory bf = new XmlBeanFactory(src);
//		User u = (User) bf.getBean("u");
//		System.out.println(u);
		

		// ApplicationContext的对象，就是一个容器，容器就是一个集合，该集合中存放了多个java对象。
		// 容器中的java对象，是怎么样生成的呢？ 是根据在创建ApplicationContext对象时，所加载的配置文
		// 配置文件中配置了哪些bean，容器中就会存放哪些bean。
		
		// 注意哦，默认情况下，spring ioc容器会在加载配置文件的时候，就把配置文件中所配置的bean，都一一实例化出来！
		// 而容器在实例化bean的时候，默认只会使用无参构造器
		
		
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/e_hello2/applicationContext.xml");
		
		User u = (User) ctx.getBean("u");  
		User u2 = (User) ctx.getBean("u");  
		User u3 = (User) ctx.getBean("u");  
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u3);
		
	}
	
	
}
