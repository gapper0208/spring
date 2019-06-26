package com.woniuxy.s_aop4;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(200)
public class A {
	
	@Pointcut("execution(public int com.woniuxy.s_aop4.CalcImpl.*(int, int))")
	public void abc() {
	}
	
	@Before("abc()")
	public void f1() {
		System.out.println("A«∞÷√");
	}
	@After("abc()")
	public void f2() {
		System.out.println("A∫Û÷√");
	}
	
}
