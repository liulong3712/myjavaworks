package designpatterns.prototype;

/*
 * 原型模式
 */

/*
 * clone的抽象原型
 */
interface CloneInterface {
	public CloneInterface clone();
	public void showName();
}

/*
 * 具体的clone原型
 */
class ConcretePrototypeA implements CloneInterface{

	private String PrototypeName;
	public ConcretePrototypeA(String PrototypeName) {
		this.PrototypeName = PrototypeName;
	}
	public void showName() {
		System.out.println(PrototypeName);
	}
	@Override
	public CloneInterface clone() {
		CloneInterface cloneable = new ConcretePrototypeA(this.PrototypeName);
		return cloneable;
	}
	public String getPrototypeName() {
		return PrototypeName;
	}
	public void setPrototypeName(String prototypeName) {
		PrototypeName = prototypeName;
	}
	
}
public class Prototype {

	public static void main(String[] args) {
		ConcretePrototypeA myConcretePrototype = new ConcretePrototypeA("hello");
		myConcretePrototype.showName();
		ConcretePrototypeA newAble = (ConcretePrototypeA)myConcretePrototype.clone();
		newAble.showName();
		//下面证明clone成功了
		newAble.setPrototypeName("改一下");
		myConcretePrototype.showName();
		newAble.showName();
	}
}
