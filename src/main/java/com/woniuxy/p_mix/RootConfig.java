package com.woniuxy.p_mix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(MyConfig.class)
@ImportResource("com/woniuxy/p_mix/applicationContext.xml")
public class RootConfig {
	
	@Bean
	public User u(Car c) {
		User user = new User();
		user.setId(111);
		user.setName("aaa");
		user.setCar(c);
		return user;
	}
}