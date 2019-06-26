package com.woniuxy.c_factorymethod;


/*
 	工厂方法模式，就是为了解决简单工厂在扩展新产品时，会违反开闭原则的问题而诞生的！！
 	
 	同时工厂方法模式仍然具备简单工厂的优点：把具体类型从客户端解耦出来！客户端不需要知道具体产品的类名。
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


interface FoodFactory {
	Food getFood();
}
class HamburgerFactory implements FoodFactory {
	@Override
	public Food getFood() {
		return new Hambergur();
	}
}
class FrenchFriedFactory implements FoodFactory {
	@Override
	public Food getFood() {
		return new FrenchFried();
	}
}

class Service {
	
	public void taste(FoodFactory ff) {
		Food food = ff.getFood();
		System.out.println("评委1，色:");
		food.eat();
		System.out.println("评委2，香:");
		food.eat();
		System.out.println("评委3，味:");
		food.eat();
	}
	
}


// ========================================================================

class Rice implements Food {
	@Override
	public void eat() {
		System.out.println("蛋炒饭！！");
	}
}

class RiceFactory implements FoodFactory {
	@Override
	public Food getFood() {
		return new Rice();
	}
}

/*
	工厂方法的优点：
	1 . 工厂接口的名字，和工厂实现类的名字，应该趋向于稳定，应为这是对外暴露出去的“承诺”, 就能把具体类名从客户端解耦出来！
	2.当客户端想要扩展一个新的具体产品时，在工厂方法模式下，根本不需要修改作者的代码。这样就符合了开闭原则。
*/

public class AppTest {
	public static void main(String[] args) {
		FoodFactory ff = new RiceFactory();
		
		Food food = ff.getFood();  
		
//		Service s = new Service();
//		s.taste(ff);
		
	}
}

// =========================================================

// 工厂方法的缺点是：当有多个产品等级的时候，工厂的实现类，就“爆炸”了！！ 
// 为了解决这个问题，我们需要使用抽象工厂！
