package com.woniuxy.b_simplefactory.b;

/*
 ����ģʽ������֪���ĸ��
 1. �����Ʒ
 		�����ࡢ�ӿھͳ�֮Ϊ�����Ʒ
 2. �����Ʒ
 		ʵ���˳������ӿڵ��࣬���Ǿ����Ʒ
 3. ��Ʒ��
 4. ��Ʒ�ȼ�
*/


interface Food {
	void eat();
}

class Hambergur3 implements Food {
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

/*
	���������˼򵥹���֮�������Σ�
	1. ��֤�򵥹����������ǹ̶��ģ�ӦΪ��������������Ҫ���Ⱪ¶��ȥ�Ľӿڣ����Թ���������Ӧ���������ȶ�������ҵ�ڵĹ淶��
	2. ����������Ʒ��ӳ���ϵҲҪ�������ȶ�
		1��Ӧ������
		2��Ӧ����
	3. ��Ҫ�����׵�api�ĵ���˵��ʲô����ӳ��ʲô��Ʒ��
	
	�򵥹������ŵ��ǣ�
	1. �������޸��˾����Ʒ������ʱ���ͻ��˲�֪����
	2.�����򵥹����ͰѾ��������ӿͻ��˴����н�������ˣ�
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
		System.out.println("����������");
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
 	�򵥹�����ȱ���ǣ�
 	1. �ͻ��˲��ò���ס�����ĳ�������Ӧʲô��Ʒ�������100����Ʒ
 	2.����Ʒһ�࣬�ͻ�����򵥹����Ĵ��뼱���������������ά���ĺ����
 	3.��������ȱ���ǣ��仯���ˣ� �ͻ�����Ҫ���һ���Զ���Ĳ�Ʒʱ����Ҫ�ڼ򵥹����ж��һ��case��
 	 ������Ҫ�޸ķ������˵Ĵ���ѽ�� ��Υ���˿���ԭ��
 	
*/