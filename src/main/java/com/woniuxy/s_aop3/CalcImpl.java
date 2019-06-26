package com.woniuxy.s_aop3;

import org.springframework.stereotype.Component;

@Component("c")
public class CalcImpl implements ICalc {
	public int add(int a, int b) {
		int r = a + b;
		System.out.println("CalcImpl.add()");
		return r;
	}

	public int sub(int a, int b) {
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		return r;
	}

	public int mul(int a, int b) {
		int r = a * b;
		System.out.println("CalcImpl.mul()");
		return r;
	}

	public int div(int a, int b) {
		int r = a / b;
		System.out.println("CalcImpl.div()");
		return r;
	}
}
