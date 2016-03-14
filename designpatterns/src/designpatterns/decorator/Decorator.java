package designpatterns.decorator;
//package designpatterns;
/*
 * װ����ģʽ
 */
//���󹹼���ɫ�������ʥ���ӿڶ�����һ��move()�������������еľ��幹�����װ�������ʵ�ֵġ�
//��ʥ�����
interface TheGreatestSage {

  public void move();
}

//���幹����ɫ����ʥ���������
class Monkey implements TheGreatestSage {

    public void move() {
        //����
        System.out.println("Monkey Move");
    }
    
    public void eat() {
    	System.out.println("Monkey Eat");
    }

}

//����װ�ν�ɫ����ʮ���䡱
class Change implements TheGreatestSage {
    private TheGreatestSage sage;
    
    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
    
    public void move() {
        // ����
        sage.move();
    }
//    public void eat() {
//    	sage.
//    }
}

//����װ�ν�ɫ�������
class Fish extends Change {
    
    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // ����
        System.out.println("Fish Move");
    }
}

//����װ�ν�ɫ�������
class Bird extends Change {
    
    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // ����
        System.out.println("Bird Move");
    }
}
public class Decorator {

	public static void main(String[] args) {
        Change MyChange1 = new Change(new Bird(new Monkey()));
        Change MyChange2 = new Change(new Fish(new Monkey()));
        MyChange1.move();
        MyChange2.move();
	}

}
