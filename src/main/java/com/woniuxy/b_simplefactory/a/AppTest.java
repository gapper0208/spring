package com.woniuxy.b_simplefactory.a;

/*
 工厂模式，必须知道的概念：
 1. 抽象产品
 		抽象类、接口就称之为抽象产品
 2. 具体产品
 		实现了抽象类或接口的类，就是具体产品
 3. 产品簇
 4. 产品等级
*/


interface Food {
	void eat();
}

class Hambergur implements Food {
	@Override
	public void eat() {
		System.out.println("吃KFC的汉堡包");
	}
}

class FrenchFried implements Food {
	@Override
	public void eat() {
		System.out.println("吃KFC的薯条");
	}
}

// ===================================================================

public class AppTest {
	public static void main(String[] args) {
		// 此时，客户端代码，不但知道了服务器端代码的接口类型，还知道了服务器端代码的具体类名
		// 这样就违反了面向接口编程的原则。
		
		// 违反这个面向接口编程的原则的缺点是： 当作何改变类的名字时，客户端代码就会崩溃，客户端代码就要跟着一起修改类名！
		// 这就叫做服务器代码与客户端代码耦合了! 所谓耦合，就是一方变化，也会引起另一方的变化！！
		
		// 为了解决这个问题，我们才需要使用 简单工厂设计模式！
		
		// 注意，这不意味着以后不让你自己使用new 类名()的方式来创建对象， 如果代码从头到尾都是你自己写的，你可以随便用类名。
		// 当你使用别人做的功能模块时，最好使用别人提供好的工厂来获取对象，而不是直接实例化别人的类。
		Food f = new FrenchFried();
		f.eat();
	}
}
