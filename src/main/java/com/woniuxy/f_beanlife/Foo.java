package com.woniuxy.f_beanlife;

import java.io.Serializable;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Foo implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("init :" + bean + ", " + beanName);
		
		User user = (User) bean;
		user.setName("�Ŵ�ɽ");
		// init�з��ص�ֵ���ᴫ��after�ĵ�һ������
		return user;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after :" + bean + ", " + beanName);
		// after�еķ���ֵ���ͻ���빤����
		User user = (User) bean;
		user.setName("������");
		return user;
	}

}
