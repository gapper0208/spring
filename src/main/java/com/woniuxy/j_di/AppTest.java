package com.woniuxy.j_di;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 我们已经知道，ioc是控制反转的意思，也就是需要一个对象时，本来是要在程序中自己实例化的，现在是由spring ioc容器提前实例化好，
 等到想要使用的时候，直接向容器索取。
 
所谓di，全称是 dependecy injection 就是依赖注入!
 而di也是ioc的另一种体现，只不过ioc侧重于由容器来实例化bean，而di则侧重于在容器实例化bean之后，还要为bean的属性注入值！
 
 
*/

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/j_di/applicationContext.xml");
		
		User u = (User) ctx.getBean("u9");
		
		System.out.println(u);
		System.out.println(u.getCar());
	}
	
	
}
