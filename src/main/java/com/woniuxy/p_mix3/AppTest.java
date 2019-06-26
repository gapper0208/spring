package com.woniuxy.p_mix3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// 注意，@ContextConfiguration可以通过locations同时加载多个xml配置，也可以使用classes同时加载多个JavaConfig配置
// 但是，不能同时使用locations和classes！！
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"applicationContext.xml","beans.xml"})
public class AppTest {

	@Resource
	private User u;
	
	@Resource
	private User u2;
	
//	@Resource
//	private User u3;
	
	@Test
	public void test() throws Exception {
		System.out.println(u);
		System.out.println(u2);
//		System.out.println(u3);
	}
}