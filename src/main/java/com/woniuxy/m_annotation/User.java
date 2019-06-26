package com.woniuxy.m_annotation;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable {  
	@Value("111")
	private Integer id;
	@Value("haha")
	private String name;
	
	/*
	 @Autowiredע��������ǣ��������Զ�װ�䣺
	 1. �ҵ�һ����װ��ɹ�
	 2.�Ҳ���
	 	���Autowired��required="true"�����׳��쳣 ���Աȣ�xml��ʽ��autowired�����Ҳ���ʱ����ע��null��
	 	���Autowired��required="false"����ע��null
	 3.�ҵ����
	 	���һ����ɨ������ģ���һ����xml����ʾ���õģ���������ɨ�������
	 	�����������xml��ʾ���õģ����׳��쳣��
	 	���һ����ɨ������ģ�����2����xml��ʾ���õģ�������ʹ��ɨ�������
		@Autowired(required = true) 
	*/
	
	/*
	 @Resource�ǰ�������װ�䣬Ҳ���ǵ�ǰCar����ı�������car����spring�ͻ��������������ֽ�car��bean��ע��
	 1. �ҵ�һ����װ��ɹ�
	 2.�Ҳ�������ת����������
	 3.�ҵ������
		���һ����ɨ���������һ����xml����ʾ���õģ�������ʹ��xml�е�
		�����������xml�����õģ��򱨴������������Ϊid�ظ�����
	 */
	@Resource
	private Car car;
	
	public User() {
		System.out.println("User.User()");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}


	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
