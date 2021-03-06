package designpatterns.birdge;

/*
 * 桥接模式
 */
/*
 * 就拿汽车在路上行驶的来说。即有小汽车又有公共汽车，它们都不但能在市区中的公路上行驶，也能在高速公路上行驶。
 */

//先定义抽像汽车
abstract class AbstractCar{
	public abstract void Run();
}
//定义抽像的路
abstract class AbstractRoad{
	protected AbstractCar oneCar;
	public abstract void Run();
	public AbstractCar getOneCar() {
		return oneCar;
	}
	public void setOneCar(AbstractCar oneCar) {
		this.oneCar = oneCar;
	}
}
//定义高速公路
class SpeedWay extends AbstractRoad{

	@Override
	public void Run() {
		oneCar.Run();
		System.out.println("高速公路上行驶");
	}
	
}
//定义城镇公路
class Street extends AbstractRoad{

	@Override
	public void Run() {
		oneCar.Run();
		System.out.println("城镇公路上行驶");
	}
	
}

//定义小汽车
class Car extends AbstractCar {

	@Override
	public void Run() {
		System.out.print("小汽车在");
	}
	
}
//定义公交车
class Bus extends AbstractCar {

	@Override
	public void Run() {
		System.out.print("公共汽车在");
	}
	
}
//定义人抽象类
abstract class AbstractPeople{
	AbstractRoad myRoad;
	public abstract void Run();
	public AbstractRoad getOneRoad() {
		return myRoad;
	}
	public void setOneRoad(AbstractRoad oneLoad) {
		this.myRoad = oneLoad;
	}
}
//定义具体的人wangwu
class Wangwu extends AbstractPeople {

	@Override
	public void Run() {
		System.out.print("王五驾驶");
		myRoad.Run();	
	}
}
//定义具体的人zhangsan
class Zhangsan extends AbstractPeople {

	@Override
	public void Run() {
		System.out.print("张三驾驶");
		myRoad.Run();	
	}
}
public class Birdge {
	public static void main(String[] args) {
		AbstractPeople wangwu = new Wangwu();
		AbstractPeople zhangsan = new Zhangsan();
		AbstractRoad road1 = new SpeedWay();
		road1.setOneCar(new Car());
//		road1.Run();
//		road1.setOneCar(new Bus());
//		road1.Run();
		
		AbstractRoad road2 = new Street();
		road2.setOneCar(new Bus());
//		road2.Run();
//		road2.setOneCar(new Car());
//		road2.Run();
		
		wangwu.setOneRoad(road1);
		wangwu.Run();
		wangwu.setOneRoad(road2);
		wangwu.Run();
	}
}
