package com.woniuxy.a_init.demter.negtive;

import org.junit.Test;

/*
	�����ӽ����ˣ������ط���
	�����ط���һ������������࣬Ӧ��֪����Խ��Խ�ã����Ե����ط���Ҳ����������֪��ԭ��
*/

class Computer {
	
	public void saveData() {
		System.out.println("����Ӧ�ó�������");
	}
	
	public void closeApp() {
		System.out.println("�ر�Ӧ�ó���");
	}
	
	public void closeScreen() {
		System.out.println("�ر���Ļ");
	}
	
	public void powerOff() {
		System.out.println("�رյ�Դ");
	}
	
}

public class AppTest {
	@Test
	public void test() throws Exception {
		// ���������������û����ԣ�֪����̫���ˣ�
		// �ͺ����������4����ť���ֱ��ǣ��������ݡ��ر�App���ر���Ļ���ϵ硣
		// ���û�Ҫ�ػ�ʱ���û�����ʮ������ػ����Ⱥ�˳�� 
		// ��һ�û�����ˣ���ô���ݾͶ�ʧ�ˡ�
		// ������Υ���˵����ط���
		Computer c = new Computer();
		c.saveData();
		c.closeApp();
		c.closeScreen();
		c.powerOff();
	}
}
