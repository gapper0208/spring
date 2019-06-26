package com.woniuxy.s_aop4;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-11)
public class B {
	@Before("execution(public int com.woniuxy.s_aop4.CalcImpl.*(int, int))")
	public void f1() {
		System.out.println("B«∞÷√");
	}
	@After("execution(public int com.woniuxy.s_aop4.CalcImpl.*(int, int))")
	public void f2() {
		System.out.println("B∫Û÷√");
	}
	
}
