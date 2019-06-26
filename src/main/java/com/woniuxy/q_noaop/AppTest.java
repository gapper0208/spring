package com.woniuxy.q_noaop;

import org.junit.Test;

/*
 在没有aop的情况下，缺点是：
 1. 为了给以前的类添加非核心业务功能，一定要修改源代码，这样势必会违反开闭原则！
 2. 甚至，将来在需要发生变化时，又要修改很多个地方，比如，把日志修改为英文。
 3. 将来，为ICalc添加新的方法时，新方法也要手动添加日志功能。
 总之，没有aop的日子里，维护代码的功能很难！！
*/
public class AppTest {
	@Test
	public void test() throws Exception {
		ICalc c = new CalcImpl();
		c.add(2, 3);
	}
}
