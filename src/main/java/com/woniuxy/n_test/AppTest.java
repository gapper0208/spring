package com.woniuxy.n_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 	ʹ��spring�Ĳ��Կ�ܣ����뵼��spring-test����
 	
 	spring�Ĳ��Կ�ܣ����Զ�����spring ioc�����������Լ��������������ṩ�����ļ���λ��
 	ͬ������ҲҪ��spring�Ĳ��Կ���ṩ�����ļ���λ�ã�
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