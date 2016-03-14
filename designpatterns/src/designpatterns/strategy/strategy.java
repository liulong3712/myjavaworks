package designpatterns.strategy;
/*
 * ����ģʽ
 * */

/**
 * 
 * @author 
 * ���ȶ���һ�����Խӿڣ�������������˼Ҹ����Ƶ�����������ƵĽӿڡ�
 */
interface IStrategy {
	//ÿ��������ƶ���һ����ִ�е��㷨��
	public void operate();
}

/**
 * 
 * 
 * ���ǹ��ϰ�æ��ʹ��Ȩ����ɱ������
 */
class BackDoor implements IStrategy {
	public void operate() {
		System.out.println("���ǹ��ϰ�æ�������̫����Ȩʩ��ѹ����ʹ��Ȩ����ɱ����...");
	}
}

/**
 * 
 * @author 
 * ���������ܲ�Ҫ������,��������ȥ
 */
class GivenGreenLight implements IStrategy {
	public void operate() {
		System.out.println("���������ܲ�Ҫ������,��������ȥ��");	
	}
}

/**
 * 
 * @author trygf521@126.com:����
 * ����˶Ϻ󣬵�ס׷����
 */
class BlackEnemy implements IStrategy {

	public void operate() {
		System.out.println("����˶Ϻ󣬵�ס׷��...");
	}

}

/**
 * 
 * ���������������Ժ�����Ҫȥ�򿪾���
 *
 */
class Context {
	private IStrategy strategy;
	//���캯����Ҫ��ʹ���ĸ����
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
		System.out.println("----------���ƺ������������---------------");  
        //�յ������ʱ��𿪵�һ��  
        System.out.println("----------�ոյ������ʱ��𿪵�һ��---------------");  
        zhaoyun = new Context(new BackDoor());  
        zhaoyun.operate();//��ִ��  
        System.out.println("");  
          
        //�������ֲ�˼��ʱ���𿪵ڶ���  
        System.out.println("----------�����ֲ�˼�񣬲�ڶ�����---------------");  
        zhaoyun = new Context(new GivenGreenLight());  
        zhaoyun.operate();//��ִ��  
        System.out.println("");  
          
        //��Ȩ��С׷���ˣ�զ�죿�𿪵���������  
        System.out.println("----------��Ȩ��С׷���ˣ�զ�죿�𿪵���������---------------");  
        zhaoyun = new Context(new BlackEnemy());  
        zhaoyun.operate();//��ִ��  
        System.out.println(""); 

	}

}
