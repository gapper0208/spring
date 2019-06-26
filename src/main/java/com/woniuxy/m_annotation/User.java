package com.woniuxy.m_annotation;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {  
	@Value("111")
	private Integer id;
	@Value("haha")
	private String name;
	
	/*
	 @Autowired注解的作用是，按类型自动装配：
	 1. 找到一个，装配成功
	 2.找不到
	 	如果Autowired的required="true"，就抛出异常 （对比，xml方式的autowired，在找不到时，就注入null）
	 	如果Autowired的required="false"，就注入null
	 3.找到多个
	 	如果一个是扫描出来的，另一个是xml中显示配置的，则优先用扫描出来的
	 	如果两个都是xml显示配置的，则抛出异常！
	 	如果一个是扫描出来的，另外2个出xml显示配置的，则优先使用扫描出来的
		@Autowired(required = true) 
	*/
	
	/*
	 @Resource是按照名称装配，也就是当前Car对象的变量名叫car，则spring就会在容器中找名字叫car的bean来注入
	 1. 找到一个，装配成功
	 2.找不到，就转而按类型找
	 3.找到多个，
		如果一个是扫描出来，另一个是xml中显示配置的，则优先使用xml中的
		如果两个都是xml中配置的，则报错，这个报错是因为id重复！！
	 */
	@Resource
	private Car car;
	
	public User() {
		System.out.println("User.User()");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
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
