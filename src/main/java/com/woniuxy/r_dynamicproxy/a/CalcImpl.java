package com.woniuxy.r_dynamicproxy.a;

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
