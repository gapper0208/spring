package com.woniuxy.n_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 	使用spring的测试框架，必须导入spring-test依赖
 	
 	spring的测试框架，会自动创建spring ioc容器，我们自己创建容器必须提供配置文件的位置
 	同理，我们也要给spring的测试框架提供配置文件的位置！
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"applicationContext.xml"})
public class AppTest {
	
	@Autowired
	private User user;
	
	@Test
	public void test() throws Exception {
		System.out.println(user);
	}
}