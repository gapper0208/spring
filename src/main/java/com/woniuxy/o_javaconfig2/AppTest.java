package com.woniuxy.o_javaconfig2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class AppTest {
	
	@Autowired
	private User user;
	
	@Autowired
	private User user2;
	
	@Test
	public void test() throws Exception {
		System.out.println(user);
		System.out.println(user.getCar());
		
//		System.out.println(user2);
//		System.out.println(user2.getCar());
		
//		System.out.println(user == user2);
//		System.out.println(user.getCar() == user2.getCar());
	}
}