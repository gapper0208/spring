package com.woniuxy.s_aop3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"applicationContext.xml"})
public class AppTest {
	
	@Autowired
	private ICalc c;
	
	@Test
	public void test() throws Exception {
		c.add(1, 2);
		
		Modable m = (Modable) c;
		m.mod(5, 2);
		
	}
}
