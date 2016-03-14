package designpatterns.proxy;

//����ģʽ


//��������ɫ,ͨ�ýӿ�
abstract class AbstractObject {
    //����
    public abstract void operation();
}

//Ŀ������ɫ
class RealObject extends AbstractObject {
    @Override
    public void operation() {
        //һЩ����
        System.out.println("һЩ����");
    }
}

//��������ɫ
class ProxyObject extends AbstractObject{
    RealObject realObject = new RealObject();
    @Override
    public void operation() {
        //����Ŀ�����֮ǰ��������ز���
        System.out.println("before");        
        realObject.operation();        
        //����Ŀ�����֮���������ز���
        System.out.println("after");
    }
}


public class Proxy {

	public static void main(String[] args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
	}

}
