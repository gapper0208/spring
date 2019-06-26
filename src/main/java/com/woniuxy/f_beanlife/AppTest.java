package com.woniuxy.f_beanlife;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
spring ioc容器中，bean的生命周期：
1. 在创建spring ioc容器时，就会加载spring的配置文件，进而实例化配置文件中所配置的bean。
2. 在bean被实例化之后，就会被bean填充属性，在本例中，就是调用bean的setter方法。
3. 在填充完bean的属性之后，如果bean所属的类，实现了BeanNameAware接口，则spring ioc容器就会调用setBeanName方法
4. 在判断完bean所属的类，是否实现了BeanNameAware接口之后，
        如果bean所属的类实现了BeanFactroyAware，则则spring ioc容器就会调用setBeanFactroy方法
5. 在判断完bean所属的类，是否实现了BeanFactroyAware接口之后，
      如果bean所属的类实现了ApplicationContextAware，则spring ioc容器就会调用setApplicationContext方法
6. 在判断完bean所属的类，是否实现了ApplicationContextAware接口之后，
   如果"其他bean"所属的类实现了BeanPostProcessor接口，则spring ioc容器就会调用其他bean的“postProcessBeforeInitialization”方法
7. 在调用完其他bean的“预初始化方法”之后，判断bean所属的类，是否实现了InitailizingBean接口
	如果实现了该接口，则调用afterPropertiesSet
8. 在调用完afterPropertiesSet之后，如果为bean配置了自定义的初始化方法，则就调用该自定义的初始化方法
9. 在调用完自定义的初始化方法之后，就会调用BeanPostProcessor接口的“postProcessAfterInitialization”方法
10. 此时，bean就可以使用了。
11. 在即将关闭容器的时候，如果bean所属的类实现了DisposableBean接口，就会调用该接口的destroy方法
12. 如果bean还自己定义了销毁方法，就会在最后调用该方法
*/

public class AppTest {
	@Test
	public void test() throws Exception {
		
		ClassPathXmlApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/f_beanlife/applicationContext.xml");
		
		User user = (User) ctx.getBean("u");
		
		System.out.println(user);
		
		
		ctx.close();
		
	}
	
	// 经典面试题： BeanFactroy和ApplicationContext的区别
		// 1. BeanFactroy是延迟实例化，直到获取bean的时候，才实例化bean； ApplicationContext在加载配置文件时就实例化bean了。
		// 2. BeanFactory和ApplicationContext都支持BeanPostProcessor接口，
		//    但是BeanFactory需要手动注册(XmlBeanFactory的addBeanPostProcessor方法)，而ApplicationContext则是自动注册
		// 3. ApplicationContext是BeanFactory接口的子接口，所以功能更加丰富强大！！
		@Test
		public void test2() throws Exception {
			Resource src = new ClassPathResource("com/woniuxy/f_beanlife/applicationContext.xml");
			XmlBeanFactory bf = new XmlBeanFactory(src);
			
			Foo foo = (Foo) bf.getBean("f");
			
			bf.addBeanPostProcessor(foo);
			
			
			User u = (User) bf.getBean("u");
			User u2 = (User) bf.getBean("u");
			User u3 = (User) bf.getBean("u");
			
			System.out.println(u == u2);
			System.out.println(u == u3);
			
			System.out.println("over");
		}
}
