package com.woniuxy.t_xmlaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/t_xmlaop/applicationContext.xml");
		ICalc c = (ICalc) ctx.getBean("c");
		System.out.println(c.getClass());
		c.add(2, 5);
	}
}