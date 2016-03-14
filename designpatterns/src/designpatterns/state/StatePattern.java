package designpatterns.state;
/*
 * 状态模式
 */

//Context类，维护一个ConcreteState子类的实例，这个实例定义当前的状态。
class MyContext {
	private State state;
	public MyContext(State state) {
		this.state = state;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	//对请求做处理，并设置下一个状态
	public void request() {
		state.Handle(this);
	}
}

//抽象状态类，定义一个接口以封装与Context的一个特定状态相关的行为
interface State {
	public abstract void Handle(MyContext context);
}
//具体状态类，每一个子类实现一个与Context的一个状态相关的行为
class ConcreteStateA implements State {

	public void Handle(MyContext context) {
		System.out.println("当关状态是A");
		context.setState(new ConcreteStateB());
	}
	
}
//具体状态类，每一个子类实现一个与Context的一个状态相关的行为
class ConcreteStateB implements State {

	public void Handle(MyContext context) {
		System.out.println("当关状态是B");
		context.setState(new ConcreteStateA());
	}
	
}
public class StatePattern {

	public static void main(String[] args) {
		MyContext context = new MyContext(new ConcreteStateA());
		context.request();
		context.request();
		context.request();
		context.request();
	}

}
