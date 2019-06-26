package com.woniuxy.p_mix3;

import java.io.Serializable;
public class User implements Serializable {  
	private Integer id;
	private String name;
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
