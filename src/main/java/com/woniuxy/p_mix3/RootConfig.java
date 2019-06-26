package com.woniuxy.p_mix3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
	@Bean
	public User u3() {
		User user = new User();
		user.setId(123);
		user.setName("ºôºôºô");
		return user;
	}
}
