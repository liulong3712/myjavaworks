package designpatterns.facade;

/*
 * 外观模式
 * 做一件事需要有多个操作完成，每个操作的完成是独立的，形成一个独立的对象，再将所有独立的对象
 * 封装到一个大的对象中统一调用，降低每个对象之间的偶合性。
 */

class DrawerOne {  
    public void open(){  
       System.out.println("第一个抽屉被打开了");  
       getKey();  
    }  
    public void getKey(){  
       System.out.println("得到第二个抽屉的钥匙");  
    }  
}  
class DrawerTwo{  
    public void open(){  
       System.out.println("第二个抽屉被打开了");  
       getFile();  
    }  
    public void getFile(){  
       System.out.println("得到这个重要文件2");  
    }  
}  

class DrawerThree{  
    public void open(){  
       System.out.println("第三个抽屉被打开了");  
       getFile();  
    }  
    public void getFile(){  
       System.out.println("得到这个重要文件3");  
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
