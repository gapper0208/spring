package com.woniuxy.g_factorybean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
 BeanFactory��FactoryBean������
 1. BeanFactory��һ��spring ioc������ FactoryBeanֻ��һ��bean��
 2. ���spring ioc���������bean����������ʵ����FactoryBean�ӿڣ���spring ioc�����ǲ���ֱ�ӰѸ��౾���ʵ������������
    ���ǰѸ����getObject�������صĶ�����������С� 
 3. �����ʵ����FactoryBean��ǰ��֮�£������ȡ��ǰ�౾�����ڻ�ȡbean��ʱ����bean������ǰ���ϡ�&������
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
