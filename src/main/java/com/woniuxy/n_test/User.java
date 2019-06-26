package com.woniuxy.n_test;

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

	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
