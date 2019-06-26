package com.woniuxy.d_abstractfactory.a;


/*
 	抽象工厂模式，就是为了解决工厂方法在面对多个产品等级时，造成的工厂类爆炸的问题！
 	
 	同时抽象工厂模式仍然具备工厂方法的优点
 		把具体类型从客户端解耦出来！客户端不需要知道具体产品的类名。
 		可以扩展新的产品，而不违反开闭原则
 		
 	目前非要使用工厂方法来产生多个产品等级的产品，发现工厂类，确实爆炸了！！
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


interface Drink {
	void drink();
}

class Cola implements Drink {
	@Override
	public void drink() {
		System.out.println("可口可乐，你值得拥有！");
	}
}
class IcePeak implements Drink {
	@Override
	public void drink() {
		System.out.println("从小就喝它！！");
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


interface DrinkFactory {
	Drink getDrink();
}

class ColaFactory implements DrinkFactory {
	@Override
	public Drink getDrink() {
		return new Cola();
	}
}
class IcePeakFactory implements DrinkFactory {
	@Override
	public Drink getDrink() {
		return new IcePeak();
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

public class AppTest {
	public static void main(String[] args) {
		FoodFactory ff = new RiceFactory();
		Service s = new Service();
		s.taste(ff);
	

	}
}
