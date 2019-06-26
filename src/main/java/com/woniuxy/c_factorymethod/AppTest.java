package com.woniuxy.c_factorymethod;


/*
 	��������ģʽ������Ϊ�˽���򵥹�������չ�²�Ʒʱ����Υ������ԭ�������������ģ���
 	
 	ͬʱ��������ģʽ��Ȼ�߱��򵥹������ŵ㣺�Ѿ������ʹӿͻ��˽���������ͻ��˲���Ҫ֪�������Ʒ��������
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

/*
	�����������ŵ㣺
	1 . �����ӿڵ����֣��͹���ʵ��������֣�Ӧ���������ȶ���ӦΪ���Ƕ��Ⱪ¶��ȥ�ġ���ŵ��, ���ܰѾ��������ӿͻ��˽��������
	2.���ͻ�����Ҫ��չһ���µľ����Ʒʱ���ڹ�������ģʽ�£���������Ҫ�޸����ߵĴ��롣�����ͷ����˿���ԭ��
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

// ����������ȱ���ǣ����ж����Ʒ�ȼ���ʱ�򣬹�����ʵ���࣬�͡���ը���ˣ��� 
// Ϊ�˽��������⣬������Ҫʹ�ó��󹤳���
