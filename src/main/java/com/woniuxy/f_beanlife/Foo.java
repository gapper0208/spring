package com.woniuxy.f_beanlife;

import java.io.Serializable;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Foo implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("init :" + bean + ", " + beanName);
		
		User user = (User) bean;
		user.setName("张翠山");
		// init中返回的值，会传给after的第一个参数
		return user;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after :" + bean + ", " + beanName);
		// after中的返回值，就会放入工厂中
		User user = (User) bean;
		user.setName("张三丰");
		return user;
	}

}
