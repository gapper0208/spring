package com.woniuxy.r_dynamicproxy.b;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 1. 讲解在目标类没有实现接口的情况下，如何完成动态代理
 2. 首先要明确的是，肯定用不了jdk的内置动态代理。
 3. 应该使用cglib，导入cglib的依赖
 
 cglib实现动态代理的原理是，代理类把目标类当做父类来继承。那么代理类就是目标类的子类
 然后代理类就要重写父类的方法，在重写父类的方法时，达到代理的目标（控制目标方法是否能执行）
 
 我们可以以下面的静态代理为参照，理解以下cglib所实现的动态代理的原理
    class Fu {
		public void f1() {
			System.out.println("Fu.f1()");
		}
	}
	class Zi extends Fu {
		@Override
		public void f1() {
			System.out.println("AAAAAAAAA");
			if(特定条件成立)
				super.f1();
			System.out.println("BBBBBBBBB");
		}
	}
*/


public class AppTest {
	@Test
	public void test() throws Exception {
		// 目标对象
		CalcImpl c = new CalcImpl();
		
		//
		Enhancer en = new Enhancer();
		// 把c所属的类CalcImpl，设置为父类
		en.setSuperclass(c.getClass());
		
		// 设置调用处理器
		en.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy mp) throws Throwable {
				System.out.println("hahahah");
				Object r = method.invoke(c, args);
				System.out.println("xixixi");
				return r;
			}
		});
		
		// 创建代理对象，该代理对象所属的类，已经继承了CalcImpl
		CalcImpl proxy = (CalcImpl) en.create();
		
		proxy.add(2, 3);
		proxy.sub(2, 3);
	}
}
