package com.woniuxy.s_aop4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConifg.class})
public class AppTest {
	
	@Resource
	private ICalc c;
	
	@Test
	public void test() throws Exception {
		c.add(1, 2);
		
	}
}
