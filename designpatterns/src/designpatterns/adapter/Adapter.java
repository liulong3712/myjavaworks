package designpatterns.adapter;
//package designpatterns;

//适配器模式
//已存在的、具有特殊功能、但不符合我们既有的标准接口的类
class Adaptee {
	public void specificRequest() {
		System.out.println("被适配类具有 特殊功能...");
	}
}

//目标接口，或称为标准接口
interface Target {
	public void request();
}

//具体目标类，只提供普通功能
class ConcreteTarget implements Target {
	public void request() {
		System.out.println("普通类 具有 普通功能...");
	}
}

//适配器类，继承了被适配类，同时实现标准接口
//属于“类适配器”
class AdapterTest1 extends Adaptee implements Target{
	public void request() {
		super.specificRequest();
	}
}

//适配器类，直接关联被适配类，同时实现标准接口
//属于“对象适配器类”
class AdapterTest2 implements Target{
	// 直接关联被适配类
	private Adaptee adaptee;
	
	// 可以通过构造函数传入具体需要适配的被适配类对象
	public AdapterTest2 (Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	public void request() {
		// 这里是使用委托的方式完成特殊功能
		this.adaptee.specificRequest();
	}
}

public class Adapter {

	public static void main(String[] args) {
		// 使用普通功能类
		Target concreteTarget = new ConcreteTarget();
		concreteTarget.request();
		
		// 1、使用特殊功能类，即类适配器
		Target adapter1 = new AdapterTest1();
		adapter1.request();
		
		// 2、使用特殊功能，即对象适配器
		Target adapter2 = new AdapterTest2(new Adaptee());
		adapter2.request();

	}

}
