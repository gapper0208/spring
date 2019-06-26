package com.woniuxy.p_mix;

import javax.annotation.Resource;

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
	
	@Resource
	private User u;
	
	@Resource
	private User u2;
	
	@Resource
	private User u3;
	
	@Test
	public void test() throws Exception {
		System.out.println(u);
		System.out.println(u.getCar());
		System.out.println(u2);
		System.out.println(u3);
		
	}
}