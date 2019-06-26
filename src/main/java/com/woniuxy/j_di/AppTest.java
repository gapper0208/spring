package com.woniuxy.j_di;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 �����Ѿ�֪����ioc�ǿ��Ʒ�ת����˼��Ҳ������Ҫһ������ʱ��������Ҫ�ڳ������Լ�ʵ�����ģ���������spring ioc������ǰʵ�����ã�
 �ȵ���Ҫʹ�õ�ʱ��ֱ����������ȡ��
 
��νdi��ȫ���� dependecy injection ��������ע��!
 ��diҲ��ioc����һ�����֣�ֻ����ioc��������������ʵ����bean����di�������������ʵ����bean֮�󣬻�ҪΪbean������ע��ֵ��
 
 
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
