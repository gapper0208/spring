package com.woniuxy.s_aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	
	@Around(value="execution(public int com.woniuxy.s_aop3.CalcImpl.*(..))")
	public Object f1(ProceedingJoinPoint pjp) {
		Object r = null;
		try {
			System.out.println("前置通知");
			// 执行目标方法
			r = pjp.proceed();
			System.out.println("返回通知");
			return r;
		} catch (Throwable e) {
			System.out.println("异常通知");
			throw new RuntimeException(e);
		} finally {
			System.out.println("后置通知");
		}
	}
}
