package com.woniuxy.q_noaop;

public class CalcImpl implements ICalc {
	public int add(int a, int b) {
		System.out.println("add��ʼ");
		int r = a + b;
		System.out.println("CalcImpl.add()");
		System.out.println("add����");
		return r;
	}

	public int sub(int a, int b) {
		System.out.println("sub��ʼ");
		int r = a - b;
		System.out.println("CalcImpl.sub()");
		System.out.println("sub����");
		return r;
	}

	public int mul(int a, int b) {
		System.out.println("mul��ʼ");
		int r = a * b;
		System.out.println("CalcImpl.mul()");
		System.out.println("mul����");
		return r;
	}

	public int div(int a, int b) {
		System.out.println("div��ʼ");
		int r = a / b;
		System.out.println("CalcImpl.div()");
		System.out.println("div����");
		return r;
	}

}

