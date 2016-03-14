package designpatterns.strategy;
/*
 * 策略模式
 * */

/**
 * 
 * @author 
 * 首先定义一个策略接口，这是诸葛亮老人家给赵云的三个锦囊妙计的接口。
 */
interface IStrategy {
	//每个锦囊妙计都是一个可执行的算法。
	public void operate();
}

/**
 * 
 * 
 * 找乔国老帮忙，使孙权不能杀刘备。
 */
class BackDoor implements IStrategy {
	public void operate() {
		System.out.println("找乔国老帮忙，让吴国太给孙权施加压力，使孙权不能杀刘备...");
	}
}

/**
 * 
 * @author 
 * 告诉刘备曹操要来打荆州,催刘备回去
 */
class GivenGreenLight implements IStrategy {
	public void operate() {
		System.out.println("告诉刘备曹操要来打荆州,催刘备回去！");	
	}
}

/**
 * 
 * @author trygf521@126.com:阿福
 * 孙夫人断后，挡住追兵。
 */
class BlackEnemy implements IStrategy {

	public void operate() {
		System.out.println("孙夫人断后，挡住追兵...");
	}

}

/**
 * 
 * 三个精囊做好了以后，赵云要去打开精囊
 *
 */
class Context {
	private IStrategy strategy;
	//构造函数，要你使用哪个妙计
	public Context(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void operate(){
		this.strategy.operate();
	}
}

public class strategy {

	public static void main(String[] args) {
		Context zhaoyun;  
		System.out.println("----------赵云和刘备到达吴国---------------");  
        //刚到吴国的时候拆开第一个  
        System.out.println("----------刚刚到吴国的时候拆开第一个---------------");  
        zhaoyun = new Context(new BackDoor());  
        zhaoyun.operate();//拆开执行  
        System.out.println("");  
          
        //当刘备乐不思蜀时，拆开第二个  
        System.out.println("----------刘备乐不思蜀，拆第二个了---------------");  
        zhaoyun = new Context(new GivenGreenLight());  
        zhaoyun.operate();//拆开执行  
        System.out.println("");  
          
        //孙权的小追兵了，咋办？拆开第三个锦囊  
        System.out.println("----------孙权的小追兵了，咋办？拆开第三个锦囊---------------");  
        zhaoyun = new Context(new BlackEnemy());  
        zhaoyun.operate();//拆开执行  
        System.out.println(""); 

	}

}
