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

	// ����֪ͨ��2�����룺
	// 1. �����з���ֵ
	// 2.������һ�����������ͱ�����ProceedingJoinPoint��ֻ�м�������������ſ���ֻ��Ŀ�귽����
	// ע�⣺ProceedingJoinPoint��JoinPoint���ӽӿڣ�����JoinPoint�Ĺ���ProceedingJoinPoint���߱�!
	
	// ���µ�execution�����еı��ʽ����֮Ϊ���е���ʽ���������ںε�ִ�У�
	// execution(public int com.woniuxy.s_aop2.CalcImpl.*(int,int)) ��ʾ����CalcImpl�����з�������Щ�����������int��int������
	// execution(public int com.woniuxy.s_aop2.CalcImpl.*(..)) ��ʾ����CalcImpl�����з�������Щ�����������⡣
	// execution(public double com.woniuxy.s_aop2.CalcImpl.*(double,..)) ��ʾ����CalcImpl�����з�������Щ������һ������������double���������⣬�ҷ������ͱ�����double��
	// execution(public int com.woniuxy.s_aop2.*.*(int,int))
	// execution(public int *.*(..)) ���������������ⷽ��������Ҳ�������,���Ƿ���ֵ������int�� ע�⣬ȫ����spring ioc�����е�bean��
	// execution(public * *.*(..)) ���������������ⷽ��������Ҳ�������,ͬʱ����ֵҲ������ġ����Ƿ����ķ������η�������public��
	// execution(* *.*(..)) ��������spring ioc�����е���ķ���, ���Ƽ���ôд��������Ҫ���嵽����
	
	
	/*
	@Around(value="execution(public int com.woniuxy.s_aop2.CalcImpl.add(..)) "
			+ " or execution(public int com.woniuxy.s_aop2.CalcImpl.sub(..)) ")
	*/
	/*
	@Around(value="execution(public int com.woniuxy.s_aop2.CalcImpl.add(..)) "
			+ " and (bean(c) or bean(c3)) ")
	*/
	// ͨ���е���ʽ������ȡĿ�귽���Ĳ�����
	@Around(value="execution(public int com.woniuxy.s_aop2.CalcImpl.add(..)) and args(x,y)")
	public Object f1(ProceedingJoinPoint pjp, Object x, Object y) {
		Signature signature = pjp.getSignature();
		String methodName = signature.getName();
		Object[] args = pjp.getArgs();
		Object r = 0;
		
		System.out.println(x + " ==== " + y);
		
		try {
			System.out.println("ǰ��֪ͨ:" + methodName + "��ʼ,�����ǣ�" + Arrays.toString(args));
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
	// ���ۣ�
	/*
		ǰ4��֪ͨ����Around֪ͨ�Ĺ�����һ�µģ�����Around������ƻ��ܿ���Ŀ�귽���Ƿ�ִ�С�ǰ4���޷����ƣ�
		�����Ƽ�ʹ�û���֪ͨ����
	 */
	
}
