package com.woniuxy.f_beanlife;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
spring ioc�����У�bean���������ڣ�
1. �ڴ���spring ioc����ʱ���ͻ����spring�������ļ�������ʵ���������ļ��������õ�bean��
2. ��bean��ʵ����֮�󣬾ͻᱻbean������ԣ��ڱ����У����ǵ���bean��setter������
3. �������bean������֮�����bean�������࣬ʵ����BeanNameAware�ӿڣ���spring ioc�����ͻ����setBeanName����
4. ���ж���bean�������࣬�Ƿ�ʵ����BeanNameAware�ӿ�֮��
        ���bean��������ʵ����BeanFactroyAware������spring ioc�����ͻ����setBeanFactroy����
5. ���ж���bean�������࣬�Ƿ�ʵ����BeanFactroyAware�ӿ�֮��
      ���bean��������ʵ����ApplicationContextAware����spring ioc�����ͻ����setApplicationContext����
6. ���ж���bean�������࣬�Ƿ�ʵ����ApplicationContextAware�ӿ�֮��
   ���"����bean"��������ʵ����BeanPostProcessor�ӿڣ���spring ioc�����ͻ��������bean�ġ�postProcessBeforeInitialization������
7. �ڵ���������bean�ġ�Ԥ��ʼ��������֮���ж�bean�������࣬�Ƿ�ʵ����InitailizingBean�ӿ�
	���ʵ���˸ýӿڣ������afterPropertiesSet
8. �ڵ�����afterPropertiesSet֮�����Ϊbean�������Զ���ĳ�ʼ����������͵��ø��Զ���ĳ�ʼ������
9. �ڵ������Զ���ĳ�ʼ������֮�󣬾ͻ����BeanPostProcessor�ӿڵġ�postProcessAfterInitialization������
10. ��ʱ��bean�Ϳ���ʹ���ˡ�
11. �ڼ����ر�������ʱ�����bean��������ʵ����DisposableBean�ӿڣ��ͻ���øýӿڵ�destroy����
12. ���bean���Լ����������ٷ������ͻ��������ø÷���
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
	
	// ���������⣺ BeanFactroy��ApplicationContext������
		// 1. BeanFactroy���ӳ�ʵ������ֱ����ȡbean��ʱ�򣬲�ʵ����bean�� ApplicationContext�ڼ��������ļ�ʱ��ʵ����bean�ˡ�
		// 2. BeanFactory��ApplicationContext��֧��BeanPostProcessor�ӿڣ�
		//    ����BeanFactory��Ҫ�ֶ�ע��(XmlBeanFactory��addBeanPostProcessor����)����ApplicationContext�����Զ�ע��
		// 3. ApplicationContext��BeanFactory�ӿڵ��ӽӿڣ����Թ��ܸ��ӷḻǿ�󣡣�
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
