package designpatterns.flyweight;

import java.util.HashMap;

/*
 * ��Ԫģʽ
 */

//�ȶ���һ�������FlyWeightAbstract
abstract class FlyWeightAbstract{
	public abstract void operation();
}

//ʵ�������������
class ConcreteFlyWeight1 extends FlyWeightAbstract {
	private String myString;

	public ConcreteFlyWeight1(String myString) {
		this.myString = myString;
		System.out.println("����ConcreteFlyWeight1����");
	}
	@Override
	public void operation() {
		System.out.println("Concrete1....FlyWeight" + myString);
	}
}
class ConcreteFlyWeight2 extends FlyWeightAbstract {
	private String myString;

	public ConcreteFlyWeight2(String myString) {
		this.myString = myString;
		System.out.println("����ConcreteFlyWeight2����");
	}
	@Override
	public void operation() {
		System.out.println("Concrete2....FlyWeight" + myString);
	}
}

//����һ���������ж���Ĵ���
class FlyweightFactory {
	private HashMap<String, Object> flyweights = new HashMap<String, Object>();
	public FlyweightFactory() {
		
	}
	public FlyWeightAbstract GetFileweight(String strObjName) {
		FlyWeightAbstract flyweight = (FlyWeightAbstract)flyweights.get(strObjName);
		if(flyweight == null) {
			if(strObjName.equals("ConcreteFlyWeight1")){
				flyweight = new ConcreteFlyWeight1(strObjName);
			}
			else if(strObjName.equals("ConcreteFlyWeight2")){
				flyweight = new ConcreteFlyWeight2(strObjName);
			}
			flyweights.put(strObjName, flyweight);
		}
		return flyweight;
	}
}
public class Flyweight {

	public static void main(String[] args) {
		FlyweightFactory MyFactory = new FlyweightFactory();
		MyFactory.GetFileweight("ConcreteFlyWeight1").operation();;
		MyFactory.GetFileweight("ConcreteFlyWeight2").operation();
		MyFactory.GetFileweight("ConcreteFlyWeight1").operation();
		MyFactory.GetFileweight("ConcreteFlyWeight1").operation();
		MyFactory.GetFileweight("ConcreteFlyWeight1").operation();
		MyFactory.GetFileweight("ConcreteFlyWeight2").operation();
	}

}
