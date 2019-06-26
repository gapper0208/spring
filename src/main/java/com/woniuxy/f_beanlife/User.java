package com.woniuxy.f_beanlife;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class User implements Serializable, BeanNameAware, BeanFactoryAware, ApplicationContextAware //
	, InitializingBean, DisposableBean
{  
	private Integer id;
	private String name;
	
	
	private User() {
		System.out.println("User()");
	}
	
	public void f1() {
		System.out.println("User.f1()");
	}
	public void f2() {
		System.out.println("User.f2()");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("User.setId():" + id);
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("User.setName():" + name);
		this.name = name;
	}
	
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public void setBeanName(String name) {
		System.out.println("User.setBeanName():" + name);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("User.setBeanFactory():" + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("User.setApplicationContext():" + ctx);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("User.afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("User.destroy()");
	}

	
}
