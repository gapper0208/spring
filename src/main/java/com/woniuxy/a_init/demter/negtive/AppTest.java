package com.woniuxy.a_init.demter.negtive;

import org.junit.Test;

/*
	该例子讲解了：迪米特法则。
	迪米特法则：一个类对于其他类，应该知道的越少越好，所以迪米特法则也叫做“最少知道原则”
*/

class Computer {
	
	public void saveData() {
		System.out.println("保存应用程序数据");
	}
	
	public void closeApp() {
		System.out.println("关闭应用程序");
	}
	
	public void closeScreen() {
		System.out.println("关闭屏幕");
	}
	
	public void powerOff() {
		System.out.println("关闭电源");
	}
	
}

public class AppTest {
	@Test
	public void test() throws Exception {
		// 这种做法，对于用户而言，知道的太多了！
		// 就好像电脑上有4个按钮，分别是：保存数据、关闭App、关闭屏幕、断电。
		// 当用户要关机时，用户必须十分清楚关机的先后顺序。 
		// 万一用户点错了，那么数据就丢失了。
		// 这样就违反了迪米特法则！
		Computer c = new Computer();
		c.saveData();
		c.closeApp();
		c.closeScreen();
		c.powerOff();
	}
}
