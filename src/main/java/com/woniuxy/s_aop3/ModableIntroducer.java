package com.woniuxy.s_aop3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ModableIntroducer {
	// ������Ҫ����ʲô�µĹ��ܣ��������涨�����: ����ľ���Modable����¹��ܡ�
	// @DeclareParents���ҳ���ʵ����ICalc��Ŀ���࣡���û�����µġ�+���ţ����ҵľ���ICalc�ӿڱ���
	// ǡǡ���������+�ţ����ҵľ�����ICalcΪ�����ࡣ�Ǿͻ���spring ioc�������Զ��ҵ�CalcImpl�Ĵ�����
	@DeclareParents(value = "com.woniuxy.s_aop3.ICalc+", defaultImpl = ModImpl.class)
	public Modable modable;
}
