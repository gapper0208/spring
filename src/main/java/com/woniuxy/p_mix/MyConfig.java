package com.woniuxy.p_mix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	public User u2() {
		User user = new User();
		user.setId(222);
		user.setName("bbb");
		return user;
	}
}