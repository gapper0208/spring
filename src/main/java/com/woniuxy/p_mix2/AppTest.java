package com.woniuxy.p_mix2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class AppTest {

	@Autowired
	private User u;
	
	@Autowired
	private User u2;
	
	@Autowired
	private User u3;
	
	@Test
	public void test() throws Exception {
		System.out.println(u);
		System.out.println(u2);
		System.out.println(u3);
	}
}