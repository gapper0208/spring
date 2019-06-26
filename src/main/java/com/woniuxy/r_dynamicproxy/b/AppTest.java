package com.woniuxy.r_dynamicproxy.b;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 1. ������Ŀ����û��ʵ�ֽӿڵ�����£������ɶ�̬����
 2. ����Ҫ��ȷ���ǣ��϶��ò���jdk�����ö�̬����
 3. Ӧ��ʹ��cglib������cglib������
 
 cglibʵ�ֶ�̬�����ԭ���ǣ��������Ŀ���൱���������̳С���ô���������Ŀ���������
 Ȼ��������Ҫ��д����ķ���������д����ķ���ʱ���ﵽ�����Ŀ�꣨����Ŀ�귽���Ƿ���ִ�У�
 
 ���ǿ���������ľ�̬����Ϊ���գ��������cglib��ʵ�ֵĶ�̬�����ԭ��
    class Fu {
		public void f1() {
			System.out.println("Fu.f1()");
		}
	}
	class Zi extends Fu {
		@Override
		public void f1() {
			System.out.println("AAAAAAAAA");
			if(�ض���������)
				super.f1();
			System.out.println("BBBBBBBBB");
		}
	}
*/


public class AppTest {
	@Test
	public void test() throws Exception {
		// Ŀ�����
		CalcImpl c = new CalcImpl();
		
		//
		Enhancer en = new Enhancer();
		// ��c��������CalcImpl������Ϊ����
		en.setSuperclass(c.getClass());
		
		// ���õ��ô�����
		en.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy mp) throws Throwable {
				System.out.println("hahahah");
				Object r = method.invoke(c, args);
				System.out.println("xixixi");
				return r;
			}
		});
		
		// ����������󣬸ô�������������࣬�Ѿ��̳���CalcImpl
		CalcImpl proxy = (CalcImpl) en.create();
		
		proxy.add(2, 3);
		proxy.sub(2, 3);
	}
}
