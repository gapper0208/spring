package com.woniuxy.a_init.demter.positive;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
	�����ӽ����ˣ������ط���
	�����ط���һ������������࣬Ӧ��֪����Խ��Խ�ã����Ե����ط���Ҳ����������֪��ԭ��
	
	
	ֻ������ͨ�ţ�ֻҪ�����ѣ��Ϳ�������������ѵ��κη�������ôʲô�����ѣ�
	1. ��������
	2 �����ķ���ֵ
	3 �����Լ������Ķ���
	4 ��ĳ�Ա����
	
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
		System.out.println("����Ӧ�ó�������");
	}
	
	private void closeApp() {
		System.out.println("�ر�Ӧ�ó���");
	}
	
	private void closeScreen() {
		System.out.println("�ر���Ļ");
	}
	
	private void powerOff() {
		System.out.println("�رյ�Դ");
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
