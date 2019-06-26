package com.woniuxy.e_hello2;

import java.io.Serializable;

public class User implements Serializable {
	private Integer id;
	private String name;
	
	
	
	private User() {
		System.out.println("User()");
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
