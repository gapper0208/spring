package com.woniuxy.o_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
 在一个普普通通的java类上，添加一个注解：@Configuration
该类就不再是一个普通类了，而是一个配置文件！ 时刻告诉自己，这是一个配置文件！ 这是一个配置文件！ 这是一个配置文件！
只不过该配置文件具备java的语法而已！！

既然是spring的配置文件，那么之前applicationContext.xml中能完成的配置，这里也都能完成！
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
	   				<property name="brand" value="奥妙" />
	   				<property name="name" value="红白" />
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
		car.setBrand("奥妙");
		car.setColor("红白");
		user.setCar(car);
		return user;
	}
	
	
	/*
	   <bean id="c3" class="com.woniuxy.o_javaconfig.Car">
	   		<property name="brand" value="宝马" />
	   		<property name="color" value="白色" />
	   </bean>
	   <bean id="u3" class="com.woniuxy.o_javaconfig.User">
	   		<property name="id" value="300" />
	   		<property name="name" value="张无忌" />
	   		<property name="car" ref="c3" />
	   </bean>
	 */
	@Bean
	public Car c3() {
		Car car = new Car();
		car.setBrand("宝马");
		car.setColor("白色");
		return car;
	}
	@Bean
	public User u3() {
		User user = new User();
		user.setId(300);
		user.setName("张无忌");
		user.setCar(c3());
		return user;
	}
	
	
	/*
	   <bean id="car" class="com.woniuxy.o_javaconfig.Car">
	   		<property name="brand" value="奔驰" />
	   		<property name="color" value="红色" />
	   </bean>
	   <bean id="u4" class="com.woniuxy.o_javaconfig.User">
	   		<property name="id" value="666" />
	   		<property name="name" value="女研究生" />
	   		<property name="car" autowired="byName" />
	   </bean>
	 */
	@Bean
	public Car car() {
		Car car = new Car();
		car.setBrand("奔驰");
		car.setColor("红色");
		return car;
	}
	@Bean
	public User u4(Car car) {
		User user = new User();
		user.setId(666);
		user.setName("女研究生");
		user.setCar(car);
		return user;
	}
}