package com.woniuxy.j_di2;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/j_di2/applicationContext.xml");
		
		Foo f = (Foo) ctx.getBean("f3");
		
		List list = f.getList();
		
		for (Object obj : list) {
			System.out.println(obj);
		}
		
		Set set = f.getSet();
		for (Object obj : set) {
			System.out.println(obj);
		}
		
		Map map = f.getMap();
		Set<Entry<String, String>> set2 = map.entrySet();
		for (Entry<String, String> e : set2) {
			System.out.println(e.getKey() + " ::: " + e.getValue());
		}
		
		Properties prop = f.getProp();
		
		Set<Entry<Object, Object>> set3 = prop.entrySet();
		for (Entry<Object, Object> e : set3) {
			System.out.println(e.getKey() + " ::: " + e.getValue());
		}
	}
}
