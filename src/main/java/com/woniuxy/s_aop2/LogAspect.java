package com.woniuxy.s_aop2;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	// 环绕通知有2个必须：
	// 1. 必须有返回值
	// 2.必须有一个参数，类型必须是ProceedingJoinPoint，只有加了这个参数，才可以只能目标方法！
	// 注意：ProceedingJoinPoint是JoinPoint的子接口，所以JoinPoint的功能ProceedingJoinPoint都具备!
	
	// 以下的execution（）中的表达式，称之为“切点表达式”，控制在何地执行！
	// execution(public int com.woniuxy.s_aop2.CalcImpl.*(int,int)) 表示拦截CalcImpl的所有方法，这些方法必须接受int，int参数。
	// execution(public int com.woniuxy.s_aop2.CalcImpl.*(..)) 表示拦截CalcImpl的所有方法，这些方法参数任意。
	// execution(public double com.woniuxy.s_aop2.CalcImpl.*(double,..)) 表示拦截CalcImpl的所有方法，这些方法第一个参数必须是double，其他任意，且返回类型必须是double。
	// execution(public int com.woniuxy.s_aop2.*.*(int,int))
	// execution(public int *.*(..)) 任意包任意类的任意方法，参数也是任意的,但是返回值必须是int。 注意，全集是spring ioc容器中的bean。
	// execution(public * *.*(..)) 任意包任意类的任意方法，参数也是任意的,同时返回值也是任意的。但是方法的访问修饰符必须是public的
	// execution(* *.*(..)) 拦截所有spring ioc容器中的类的方法, 不推荐这么写，最起码要具体到包！
	
	
	/*
	@Around(value="execution(public int com.woniuxy.s_aop2.CalcImpl.add(..)) "
			+ " or execution(public int com.woniuxy.s_aop2.CalcImpl.sub(..)) ")
	*/
	/*
	@Around(value="execution(public int com.woniuxy.s_aop2.CalcImpl.add(..)) "
			+ " and (bean(c) or bean(c3)) ")
	*/
	// 通过切点表达式，来获取目标方法的参数：
	@Around(value="execution(public int com.woniuxy.s_aop2.CalcImpl.add(..)) and args(x,y)")
	public Object f1(ProceedingJoinPoint pjp, Object x, Object y) {
		Signature signature = pjp.getSignature();
		String methodName = signature.getName();
		Object[] args = pjp.getArgs();
		Object r = 0;
		
		System.out.println(x + " ==== " + y);
		
		try {
			System.out.println("前置通知:" + methodName + "开始,参数是：" + Arrays.toString(args));
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
	// 讨论：
	/*
		前4个通知，与Around通知的功能是一致的，但是Around这个环绕还能控制目标方法是否执行。前4个无法控制！
		所以推荐使用环绕通知！！
	 */
	
}
