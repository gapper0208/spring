package com.woniuxy.s_aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 这个类，我们打算把它作为切面类
// 切面类，首先必须是一个被spring ioc容器管理的bean
// 所以必须加上@Component（或者@Service、@Repository、@Controller）
@Component
// 此时LogAspect类的实例，也仅仅只是一个被容器管理了。该类还不是切面呢！！
// 为了把LogAspect变为切面，还需要添加一个注解：@Aspect ，为了使用这个注解，还必须引入一个依赖：spring-aspects
// 切记，为了让@Aspect注解生效，还必须在xml配置中，添加一个配置：<aop:aspectj-autoproxy />
@Aspect
public class LogAspect {
	
	/*
	 注意，以下4个通知：
	 1. 前置通知和后置通知总是会执行
	 2.异常通知和返回通知，二者只能执行一个
	 3.后置通知总是在返回通知和异常通知之前执行！
	 4.只有谁能获取返回值：返回通知
	 5.只有谁能获取异常信息：异常通知
	 6.这4个通知，都有一个可选参数：JoinPoint
	*/
	
	@Before(value = "execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))")
	public void f1(JoinPoint jp) {
		// 获取方法签名
		Signature signature = jp.getSignature();
		// 获取方法名
		String methodName = signature.getName();
		// 获取参数
		Object[] args = jp.getArgs();
		
		System.out.println("前置通知:" + methodName + "开始, 参数是：" + Arrays.toString(args));
	}
	
	@AfterReturning(value="execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))",returning = "r")
	public void f2(Object r) {
		System.out.println("返回通知:" + r);
	}
	
	@AfterThrowing(value="execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))",throwing = "ex")
	public void f3(Object ex) {
		System.out.println("异常通知:" + ex);
	}
	
	@After(value="execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))")
	public void f4() {
		System.out.println("后置通知");
	}
	
}
 