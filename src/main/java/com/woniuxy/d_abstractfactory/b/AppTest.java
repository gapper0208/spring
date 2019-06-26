package com.woniuxy.d_abstractfactory.b;


/*
 	�����a�������⣬�޸Ĵ������£�
*/

interface Food {
	void eat();
}

class Hambergur2 implements Food {
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
		System.out.println("��ί1��ɫ:");
		food.eat();
		drink.drink();
		System.out.println("��ί2����:");
		food.eat();
		drink.drink();
		System.out.println("��ί3��ζ:");
		food.eat();
		drink.drink();
	}
}


// ========================================================================

class RiceNoodle implements Food {
	@Override
	public void eat() {
		System.out.println("�������ߣ���ֵ��ӵ�У�");
	}
}
class Fanta implements Drink {
	@Override
	public void drink() {
		System.out.println("��ƿ�Ҵ��");
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


// ���󹤳���ȱ���ǣ�����һ����Ʒ�ȼ���ʱ�򣬾ͻ��޸���ǰ�Ĵ��룬����Υ���˿���ԭ��
//		���磬��ʱ����һ����ˮ������Ʒ�ȼ���
// ע��Աȣ�������һ���µĲ�Ʒ�ص�ʱ�򣬳��󹤳�����Υ������ԭ��

// ���󹤳������������䵱dao�Ĺ���