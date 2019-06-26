package com.woniuxy.s_aop3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ModableIntroducer {
	// 该切面要引入什么新的功能，就在下面定义出来: 引入的就是Modable这个新功能。
	// @DeclareParents会找出，实现了ICalc的目标类！如果没有以下的“+”号，则找的就是ICalc接口本身。
	// 恰恰是有了这个+号，则找的就是以ICalc为父的类。那就会在spring ioc容器中自动找到CalcImpl的代理类
	@DeclareParents(value = "com.woniuxy.s_aop3.ICalc+", defaultImpl = ModImpl.class)
	public Modable modable;
}
