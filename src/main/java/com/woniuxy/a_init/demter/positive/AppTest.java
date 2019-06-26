package com.woniuxy.a_init.demter.positive;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
	该例子讲解了：迪米特法则。
	迪米特法则：一个类对于其他类，应该知道的越少越好，所以迪米特法则也叫做“最少知道原则”
	
	
	只和朋友通信，只要是朋友，就可以随意调用朋友的任何方法。那么什么是朋友：
	1. 方法参数
	2 方法的返回值
	3 方法自己创建的对象
	4 类的成员变量
	
*/

class Bar {
	public void xx() {
		System.out.println("Bar.xx()");
	}
}

class Foo {
	
	List<Integer> list = new ArrayList();
	
	public String f1(Date dd) {
		String s = "abc";
		
		Set set = new HashSet();
		
		Bar bar = f2();
		
		f3(bar);
		
		return s;
		
	}
	
	public void f3(Bar bar) {
		bar.xx();
	}
	
	public Bar f2() {
		return new Bar();
	}
}

class Computer {
	
	private void saveData() {
		System.out.println("保存应用程序数据");
	}
	
	private void closeApp() {
		System.out.println("关闭应用程序");
	}
	
	private void closeScreen() {
		System.out.println("关闭屏幕");
	}
	
	private void powerOff() {
		System.out.println("关闭电源");
	}
	
	public void shuwDown() {
		saveData();
		closeApp();
		closeScreen();
		powerOff();
	}
}

public class AppTest {
	@Test
	public void test() throws Exception {
		Computer c = new Computer();
		c.shuwDown();
	}
}
