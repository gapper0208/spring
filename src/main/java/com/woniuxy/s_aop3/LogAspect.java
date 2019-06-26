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
			System.out.println("ǰ��֪ͨ");
			// ִ��Ŀ�귽��
			r = pjp.proceed();
			System.out.println("����֪ͨ");
			return r;
		} catch (Throwable e) {
			System.out.println("�쳣֪ͨ");
			throw new RuntimeException(e);
		} finally {
			System.out.println("����֪ͨ");
		}
	}
}
