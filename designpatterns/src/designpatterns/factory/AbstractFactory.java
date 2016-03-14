package designpatterns.factory;

/*
 * ���󹤳�ģʽ
 */

//���е�method()�����ɿ�����ȡ����ͬ��Ʒ�Ĺ��ԣ����ֻ��������ƵĹ��� 
interface IProductA{ 
	public void method(); 
} 

interface IProductB{ 
	public void method(); 
} 

//ʵ���˲�Ʒ��׼ʵ�ֵ�һϵ�о����Ʒ 
//�����Ѿ���ƺ�A1�ɳ���1��������������������С�����x�� 
class ProductA1 implements IProductA{ 
	public void method() { 
	  System.out.println("����1    ����ProductA1 ..."); 
	} 
} 

class ProductA2 implements IProductA{ 
	public void method() { 
	  System.out.println("����2    ����ProductA2 ..."); 
	} 
}

class ProductB1 implements IProductB{ 
	  public void method() { 
	    System.out.println("����1    ����ProductB1 ..."); 
	  } 
} 

class ProductB2 implements IProductB{ 
	  public void method() { 
	    System.out.println("����2    ����ProductB2 ..."); 
	  } 
} 

//ÿһ�����ӵĲ�Ʒ��������������ͬ�ĳ��̸����Լ����Ӳ�Ʒ������ 
abstract class Factory1{ 
	abstract IProductA getProductA1(); 
	abstract IProductB getProductB1(); 
} 

abstract class Factory2{ 
	abstract IProductA getProductA2(); 
	abstract IProductB getProductB2(); 
} 

//����Ĺ�������������صĲ�Ʒ 
class ConcreteFactory1 extends Factory1{ 
	public IProductA getProductA1() { 
	  return new ProductA1(); 
	} 
	public IProductB getProductB1() { 
	  return new ProductB1(); 
	} 
} 

class ConcreteFactoryB extends Factory2{ 
	public IProductA getProductA2() { 
	  return new ProductA2(); 
	} 
	public IProductB getProductB2() { 
	  return new ProductB2(); 
	} 
} 
public class AbstractFactory {

	public static void main(String[] args) {
		 //����1����������ƷA1��B1 
	    Factory1 factory1 = new ConcreteFactory1(); 
	    factory1.getProductA1().method(); 
	    factory1.getProductB1().method(); 
	     
	    //����2����������ƷA2��B2 
	    Factory2 factory2 = new ConcreteFactoryB(); 
	    factory2.getProductA2().method(); 
	    factory2.getProductB2().method(); 

	}

}
