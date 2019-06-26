package com.woniuxy.b_simplefactory.b;

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

class Hambergur3 implements Food {
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

/*
	作者制作了简单工厂之后，有责任：
	1. 保证简单工厂的类名是固定的，应为工厂的类名就是要对外暴露出去的接口，所以工厂的名字应该趋向于稳定，这是业内的规范。
	2. 常量与具体产品的映射关系也要趋向于稳定
		1对应汉堡包
		2对应薯条
	3. 还要有配套的api文档。说明什么常量映射什么产品。
	
	简单工厂的优点是：
	1. 当作者修改了具体产品的类名时，客户端不知道！
	2.这样简单工厂就把具体类名从客户端代码中解耦出来了！
*/

class SimpleFactory {
	public static Food getFood(int i) {
		Food f = null;
		switch (i) {
			case 1:
				f = new Hambergur3();
				break;
			case 2:
				f = new FrenchFried();
		}
		return f;
	}
}

// ===================================================================

class Rice implements Food {
	@Override
	public void eat() {
		System.out.println("蛋炒饭！！");
	}
}

public class AppTest {
	public static void main(String[] args) {
		Food f = SimpleFactory.getFood(1);
		f.eat();
	}
}

// ============================================

/*
 	简单工厂的缺点是：
 	1. 客户端不得不记住大量的常量，对应什么产品。如果有100个产品
 	2.当产品一多，就会引起简单工厂的代码急剧捧场，造成难以维护的后果。
 	3.最致命的缺点是：变化来了， 客户端需要添加一个自定义的产品时，还要在简单工厂中多加一个case。
 	 这样就要修改服务器端的代码呀！ 就违反了开闭原则。
 	
*/