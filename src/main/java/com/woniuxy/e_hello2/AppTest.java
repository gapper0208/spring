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
		
		// BeanFactory��һ���ӽӿڣ�ApplicationContext, Ҳ����˵��ApplicationContext�߱�BeanFactory�����й���
		// ApplicationContext�����Լ���չ�Ĺ��ܣ���֮ApplicationContext��BeanFactory���ܸ�ǿ��
		
//		Resource src = new ClassPathResource("com/woniuxy/e_hello2/applicationContext.xml");
//		BeanFactory bf = new XmlBeanFactory(src);
//		User u = (User) bf.getBean("u");
//		System.out.println(u);
		

		// ApplicationContext�Ķ��󣬾���һ����������������һ�����ϣ��ü����д���˶��java����
		// �����е�java��������ô�����ɵ��أ� �Ǹ����ڴ���ApplicationContext����ʱ�������ص�������
		// �����ļ�����������Щbean�������оͻ�����Щbean��
		
		// ע��Ŷ��Ĭ������£�spring ioc�������ڼ��������ļ���ʱ�򣬾Ͱ������ļ��������õ�bean����һһʵ����������
		// ��������ʵ����bean��ʱ��Ĭ��ֻ��ʹ���޲ι�����
		
		
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
