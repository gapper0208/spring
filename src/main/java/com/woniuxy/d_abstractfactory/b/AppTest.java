package com.woniuxy.d_abstractfactory.b;


/*
 	针对于a包的问题，修改代码如下：
*/

interface Food {
	void eat();
}

class Hambergur2 implements Food {
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

interface Factory {
	Food getFood();
	Drink getDrink();
}

class KFCFactory implements Factory {
	@Override
	public Food getFood() {
		return new Hambergur2();
	}
	@Override
	public Drink getDrink() {
		return new Cola();
	}
}

class SanQinFactory implements Factory {
	@Override
	public Food getFood() {
		return new FrenchFried();
	}
	@Override
	public Drink getDrink() {
		return new IcePeak();
	}
}


class Service {
	public void taste(Factory ff) {
		Food food = ff.getFood();
		Drink drink = ff.getDrink();
		System.out.println("评委1，色:");
		food.eat();
		drink.drink();
		System.out.println("评委2，香:");
		food.eat();
		drink.drink();
		System.out.println("评委3，味:");
		food.eat();
		drink.drink();
	}
}


// ========================================================================

class RiceNoodle implements Food {
	@Override
	public void eat() {
		System.out.println("过桥米线，你值得拥有！");
	}
}
class Fanta implements Drink {
	@Override
	public void drink() {
		System.out.println("来瓶芬达！！");
	}
}

class WoNiuFactory implements Factory {

	@Override
	public Food getFood() {
		return new RiceNoodle();
	}

	@Override
	public Drink getDrink() {
		return new Fanta();
	}
	
}

public class AppTest {
	public static void main(String[] args) {
		Factory f1 = new KFCFactory();
		Factory f2 = new SanQinFactory();
		Factory f3 = new WoNiuFactory();
		
		
		Service service = new Service();
		service.taste(f3);

	}
}


// 抽象工厂的缺点是；当做一个产品等级的时候，就会修改以前的代码，这样违反了开闭原则，
//		比如，此时多了一个“水果”产品等级。
// 注意对比，在增加一个新的产品簇的时候，抽象工厂不用违反开闭原则。

// 抽象工厂，可以用来充当dao的工厂