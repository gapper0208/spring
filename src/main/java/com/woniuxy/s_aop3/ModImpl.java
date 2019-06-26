package com.woniuxy.s_aop3;

public class ModImpl implements Modable {
	@Override
	public int mod(int a, int b) {
		int r = a % b;
		System.out.println("ModImpl.mod()");
		return r;
	}
}
