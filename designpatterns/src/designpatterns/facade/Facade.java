package designpatterns.facade;

/*
 * ���ģʽ
 * ��һ������Ҫ�ж��������ɣ�ÿ������������Ƕ����ģ��γ�һ�������Ķ����ٽ����ж����Ķ���
 * ��װ��һ����Ķ�����ͳһ���ã�����ÿ������֮���ż���ԡ�
 */

class DrawerOne {  
    public void open(){  
       System.out.println("��һ�����뱻����");  
       getKey();  
    }  
    public void getKey(){  
       System.out.println("�õ��ڶ��������Կ��");  
    }  
}  
class DrawerTwo{  
    public void open(){  
       System.out.println("�ڶ������뱻����");  
       getFile();  
    }  
    public void getFile(){  
       System.out.println("�õ������Ҫ�ļ�2");  
    }  
}  

class DrawerThree{  
    public void open(){  
       System.out.println("���������뱻����");  
       getFile();  
    }  
    public void getFile(){  
       System.out.println("�õ������Ҫ�ļ�3");  
    }  
}  
interface FacadeInterface{   
    public void open();
}  
class DrawerFacade1 implements FacadeInterface{  
    DrawerOne darwerOne=new DrawerOne();  
    DrawerTwo darwerTwo=new DrawerTwo();  
    public void open(){  
       darwerOne.open();  
       darwerTwo.open();  
    }  
}  
class DrawerFacade2 implements FacadeInterface{  
    DrawerOne darwerOne=new DrawerOne();  
    DrawerThree darwerThree=new DrawerThree();  
    public void open(){  
       darwerOne.open();  
       darwerThree.open();  
    }  
}  

public class Facade {

	public static void main(String[] args) {
		FacadeInterface MyDrawerFacade = new DrawerFacade1();
		MyDrawerFacade.open();
		MyDrawerFacade = new DrawerFacade2();
		MyDrawerFacade.open();
	}

}
