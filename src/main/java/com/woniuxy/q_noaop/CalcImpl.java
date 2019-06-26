package com.woniuxy.q_noaop;

public class CalcImpl implements ICalc {
	public int add(int a, int b) {
		System.out.println("add开始");
		int r = a + b;
		System.out.println("CalcImpl.add()");
		System.out.println("add结束");
		return r;
	}

	public int sub(int a, int b) {
		System.out.println("sub开始");
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		System.out.println("sub结束");
		return r;
	}

	public int mul(int a, int b) {
		System.out.println("mul开始");
		int r = a * b;
		System.out.println("CalcImpl.mul()");
		System.out.println("mul结束");
		return r;
	}

	public int div(int a, int b) {
		System.out.println("div开始");
		int r = a / b;
		System.out.println("CalcImpl.div()");
		System.out.println("div结束");
		return r;
	}

}

