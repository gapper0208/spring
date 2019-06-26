package com.woniuxy.r_dynamicproxy.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

/*
 1.��ϰjdk��̬����
 2.jdk��̬�����޷�����Ŀ������������࣬û��ʵ�ֽӿڵ������(һ��ʹ��cglib���ͷ��������)
 3.��̬������ʵ����aop�ĵײ�ԭ����νaop�������������̣�ʲô�б�д�������أ� ���ǽ��������ڶ�����������
 
*/
public class AppTest {
	
	@Test
	public void test() throws Exception {
		
		// Ŀ�����
		CalcImpl c = new CalcImpl();
		
		// ��ȡĿ������������࣬��ʵ�ֵĽӿ�
		Class[] interfaces = c.getClass().getInterfaces();
		
		
		ICalc proxy = (ICalc) Proxy.newProxyInstance(AppTest.class.getClassLoader(), interfaces, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object r = null;
				try {
					System.out.println("ǰ��֪ͨ");
					r = method.invoke(c, args);
					System.out.println("����֪ͨ");
					return r;
				} catch (Exception e) {
					System.out.println("�쳣֪ͨ");
					throw new RuntimeException(e);  // �׳����쳣Ҳ�㷵��ֵ��
				} finally {
					System.out.println("����֪ͨ");
				}
			}
		});
		proxy.add(2, 3);
	}
}
