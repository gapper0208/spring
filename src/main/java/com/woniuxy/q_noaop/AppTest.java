package com.woniuxy.q_noaop;

import org.junit.Test;

/*
 ��û��aop������£�ȱ���ǣ�
 1. Ϊ�˸���ǰ������ӷǺ���ҵ���ܣ�һ��Ҫ�޸�Դ���룬�����Ʊػ�Υ������ԭ��
 2. ��������������Ҫ�����仯ʱ����Ҫ�޸ĺܶ���ط������磬����־�޸�ΪӢ�ġ�
 3. ������ΪICalc����µķ���ʱ���·���ҲҪ�ֶ������־���ܡ�
 ��֮��û��aop�������ά������Ĺ��ܺ��ѣ���
*/
public class AppTest {
	@Test
	public void test() throws Exception {
		ICalc c = new CalcImpl();
		c.add(2, 3);
	}
}
