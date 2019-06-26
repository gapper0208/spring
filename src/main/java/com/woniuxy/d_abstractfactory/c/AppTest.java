package com.woniuxy.d_abstractfactory.c;

import java.io.IOException;
import java.util.Properties;

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

interface Factory {
	Food getFood();
	Drink getDrink();
}

class KFCFactory implements Factory {
	@Override
	public Food getFood() {
		return new Hambergur();
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


class SimpleFatory {
	
	public static Factory getFactory(){
		try {
			Properties prop = new Properties();
			prop.load(SimpleFatory.class.getResourceAsStream("aa.properties"));
			String className = prop.getProperty("factory");
			Class clazz = Class.forName(className);
			return (Factory) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

// ========================================================================

public class AppTest {
	public static void main(String[] args) {
		Factory factory = SimpleFatory.getFactory();
		
		Food food = factory.getFood();
		Drink drink = factory.getDrink();
		food.eat();
		drink.drink();
	}
}


