package com.woniuxy.r_dynamicproxy.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.junit.Test;

/*
 1.复习jdk动态代理。
 2.jdk动态代理，无法处理目标对象所属的类，没有实现接口的情况！(一会使用cglib来客服这个问题)
 3.动态代理其实就是aop的底层原理，所谓aop就是面向切面编程，什么叫编写切面编程呢？ 我们将用整个第二章来将来！
 
*/
public class AppTest {
	
	@Test
	public void test() throws Exception {
		
		// 目标对象
		CalcImpl c = new CalcImpl();
		
		// 获取目标对象所属的类，所实现的接口
		Class[] interfaces = c.getClass().getInterfaces();
		
		
		ICalc proxy = (ICalc) Proxy.newProxyInstance(AppTest.class.getClassLoader(), interfaces, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object r = null;
				try {
					System.out.println("前置通知");
					r = method.invoke(c, args);
					System.out.println("返回通知");
					return r;
				} catch (Exception e) {
					System.out.println("异常通知");
					throw new RuntimeException(e);  // 抛出的异常也算返回值！
				} finally {
					System.out.println("后置通知");
				}
			}
		});
		proxy.add(2, 3);
	}
}
