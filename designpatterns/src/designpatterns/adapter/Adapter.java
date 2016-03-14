package designpatterns.adapter;
//package designpatterns;

//������ģʽ
//�Ѵ��ڵġ��������⹦�ܡ������������Ǽ��еı�׼�ӿڵ���
class Adaptee {
	public void specificRequest() {
		System.out.println("����������� ���⹦��...");
	}
}

//Ŀ��ӿڣ����Ϊ��׼�ӿ�
interface Target {
	public void request();
}

//����Ŀ���ֻ࣬�ṩ��ͨ����
class ConcreteTarget implements Target {
	public void request() {
		System.out.println("��ͨ�� ���� ��ͨ����...");
	}
}

//�������࣬�̳��˱������࣬ͬʱʵ�ֱ�׼�ӿ�
//���ڡ�����������
class AdapterTest1 extends Adaptee implements Target{
	public void request() {
		super.specificRequest();
	}
}

//�������ֱ࣬�ӹ����������࣬ͬʱʵ�ֱ�׼�ӿ�
//���ڡ������������ࡱ
class AdapterTest2 implements Target{
	// ֱ�ӹ�����������
	private Adaptee adaptee;
	
	// ����ͨ�����캯�����������Ҫ����ı����������
	public AdapterTest2 (Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	public void request() {
		// ������ʹ��ί�еķ�ʽ������⹦��
		this.adaptee.specificRequest();
	}
}

public class Adapter {

	public static void main(String[] args) {
		// ʹ����ͨ������
		Target concreteTarget = new ConcreteTarget();
		concreteTarget.request();
		
		// 1��ʹ�����⹦���࣬����������
		Target adapter1 = new AdapterTest1();
		adapter1.request();
		
		// 2��ʹ�����⹦�ܣ�������������
		Target adapter2 = new AdapterTest2(new Adaptee());
		adapter2.request();

	}

}
