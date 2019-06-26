package com.woniuxy.d_abstractfactory.a;


/*
 	���󹤳�ģʽ������Ϊ�˽��������������Զ����Ʒ�ȼ�ʱ����ɵĹ����౬ը�����⣡
 	
 	ͬʱ���󹤳�ģʽ��Ȼ�߱������������ŵ�
 		�Ѿ������ʹӿͻ��˽���������ͻ��˲���Ҫ֪�������Ʒ��������
 		������չ�µĲ�Ʒ������Υ������ԭ��
 		
 	Ŀǰ��Ҫʹ�ù������������������Ʒ�ȼ��Ĳ�Ʒ�����ֹ����࣬ȷʵ��ը�ˣ���
*/

interface Food {
	void eat();
}

class Hambergur implements Food {
	@Override
	public void eat() {
		System.out.println("��KFC�ĺ�����");
	}
}

class FrenchFried implements Food {
	@Override
	public void eat() {
		System.out.println("��KFC������");
	}
}


interface Drink {
	void drink();
}

class Cola implements Drink {
	@Override
	public void drink() {
		System.out.println("�ɿڿ��֣���ֵ��ӵ�У�");
	}
}
class IcePeak implements Drink {
	@Override
	public void drink() {
		System.out.println("��С�ͺ�������");
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
		System.out.println("��ί1��ɫ:");
		food.eat();
		System.out.println("��ί2����:");
		food.eat();
		System.out.println("��ί3��ζ:");
		food.eat();
	}
	
}


// ========================================================================

class Rice implements Food {
	@Override
	public void eat() {
		System.out.println("����������");
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
