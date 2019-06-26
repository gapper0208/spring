package com.woniuxy.o_javaconfig2;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User implements Serializable {  
	@Value("222")
	private Integer id;
	@Value("共产主义")
	private String name;
	@Autowired
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
