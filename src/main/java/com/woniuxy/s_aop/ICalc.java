package com.woniuxy.s_aop;

import org.springframework.stereotype.Component;

public interface ICalc {
	public int add(int a, int b);
	public int sub(int a, int b);
	public int mul(int a, int b);
	public int div(int a, int b);
}
