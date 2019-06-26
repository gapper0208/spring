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

// ����࣬���Ǵ��������Ϊ������
// �����࣬���ȱ�����һ����spring ioc���������bean
// ���Ա������@Component������@Service��@Repository��@Controller��
@Component
// ��ʱLogAspect���ʵ����Ҳ����ֻ��һ�������������ˡ����໹���������أ���
// Ϊ�˰�LogAspect��Ϊ���棬����Ҫ���һ��ע�⣺@Aspect ��Ϊ��ʹ�����ע�⣬����������һ��������spring-aspects
// �мǣ�Ϊ����@Aspectע����Ч����������xml�����У����һ�����ã�<aop:aspectj-autoproxy />
@Aspect
public class LogAspect {
	
	/*
	 ע�⣬����4��֪ͨ��
	 1. ǰ��֪ͨ�ͺ���֪ͨ���ǻ�ִ��
	 2.�쳣֪ͨ�ͷ���֪ͨ������ֻ��ִ��һ��
	 3.����֪ͨ�����ڷ���֪ͨ���쳣֪֮ͨǰִ�У�
	 4.ֻ��˭�ܻ�ȡ����ֵ������֪ͨ
	 5.ֻ��˭�ܻ�ȡ�쳣��Ϣ���쳣֪ͨ
	 6.��4��֪ͨ������һ����ѡ������JoinPoint
	*/
	
	@Before(value = "execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))")
	public void f1(JoinPoint jp) {
		// ��ȡ����ǩ��
		Signature signature = jp.getSignature();
		// ��ȡ������
		String methodName = signature.getName();
		// ��ȡ����
		Object[] args = jp.getArgs();
		
		System.out.println("ǰ��֪ͨ:" + methodName + "��ʼ, �����ǣ�" + Arrays.toString(args));
	}
	
	@AfterReturning(value="execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))",returning = "r")
	public void f2(Object r) {
		System.out.println("����֪ͨ:" + r);
	}
	
	@AfterThrowing(value="execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))",throwing = "ex")
	public void f3(Object ex) {
		System.out.println("�쳣֪ͨ:" + ex);
	}
	
	@After(value="execution(public int com.woniuxy.s_aop.CalcImpl.*(int, int))")
	public void f4() {
		System.out.println("����֪ͨ");
	}
	
}
 