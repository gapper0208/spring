package com.woniuxy.j_di;

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

public class User implements Serializable {  
	private Integer id;
	private String name;
	private Car car;
	
	public User() {
		System.out.println("User()");
	}
	
	public User(Integer id, String name) {
		System.out.println("User(Integer, String)");
		this.id = id;
		this.name = name;
	}
	
	public User(Integer id, String name, Car car) {
		System.out.println("User(Integer, String, Car)");
		this.id = id;
		this.name = name;
		this.car = car;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		System.out.println("User.setId()");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("User.setName()");
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}


	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
