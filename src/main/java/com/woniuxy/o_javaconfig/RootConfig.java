package com.woniuxy.o_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
 ��һ������ͨͨ��java���ϣ����һ��ע�⣺@Configuration
����Ͳ�����һ����ͨ���ˣ�����һ�������ļ��� ʱ�̸����Լ�������һ�������ļ��� ����һ�������ļ��� ����һ�������ļ���
ֻ�����������ļ��߱�java���﷨���ѣ���

��Ȼ��spring�������ļ�����ô֮ǰapplicationContext.xml������ɵ����ã�����Ҳ������ɣ�
*/
@Configuration
public class RootConfig {
	/*
	   <bean id="u" class="com.woniuxy.o_javaconfig.User" scope="prototype">
	   		<property name="id" value="100" />
	   		<property name="name" value="xyz" />
	   </bean>
	 */
	@Bean
	@Scope("prototype")
	public User u() {
		User user = new User();
		user.setId(100);
		user.setName("xyz");
		return user;
	}
	
	/*
	   <bean id="u2" class="com.woniuxy.o_javaconfig.User">
	   		<property name="id" value="200" />
	   		<property name="name" value="abc" />
	   		<property name="car">
	   			<bean class="com.woniuxy.o_javaconfig.Car">
	   				<property name="brand" value="����" />
	   				<property name="name" value="���" />
	   			</bean>
	   		</property>
	   </bean>
	 */
	@Bean
	public User u2() {
		User user = new User();
		user.setId(200);
		user.setName("abc");
		Car car = new Car();
		car.setBrand("����");
		car.setColor("���");
		user.setCar(car);
		return user;
	}
	
	
	/*
	   <bean id="c3" class="com.woniuxy.o_javaconfig.Car">
	   		<property name="brand" value="����" />
	   		<property name="color" value="��ɫ" />
	   </bean>
	   <bean id="u3" class="com.woniuxy.o_javaconfig.User">
	   		<property name="id" value="300" />
	   		<property name="name" value="���޼�" />
	   		<property name="car" ref="c3" />
	   </bean>
	 */
	@Bean
	public Car c3() {
		Car car = new Car();
		car.setBrand("����");
		car.setColor("��ɫ");
		return car;
	}
	@Bean
	public User u3() {
		User user = new User();
		user.setId(300);
		user.setName("���޼�");
		user.setCar(c3());
		return user;
	}
	
	
	/*
	   <bean id="car" class="com.woniuxy.o_javaconfig.Car">
	   		<property name="brand" value="����" />
	   		<property name="color" value="��ɫ" />
	   </bean>
	   <bean id="u4" class="com.woniuxy.o_javaconfig.User">
	   		<property name="id" value="666" />
	   		<property name="name" value="Ů�о���" />
	   		<property name="car" autowired="byName" />
	   </bean>
	 */
	@Bean
	public Car car() {
		Car car = new Car();
		car.setBrand("����");
		car.setColor("��ɫ");
		return car;
	}
	@Bean
	public User u4(Car car) {
		User user = new User();
		user.setId(666);
		user.setName("Ů�о���");
		user.setCar(car);
		return user;
	}
}