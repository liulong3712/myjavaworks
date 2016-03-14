package designpatterns.decorator;
//package designpatterns;
/*
 * 装饰者模式
 */
//抽象构件角色“齐天大圣”接口定义了一个move()方法，这是所有的具体构件类和装饰类必须实现的。
//大圣的尊号
interface TheGreatestSage {

  public void move();
}

//具体构件角色“大圣本尊”猢狲类
class Monkey implements TheGreatestSage {

    public void move() {
        //代码
        System.out.println("Monkey Move");
    }
    
    public void eat() {
    	System.out.println("Monkey Eat");
    }

}

//抽象装饰角色“七十二变”
class Change implements TheGreatestSage {
    private TheGreatestSage sage;
    
    public Change(TheGreatestSage sage){
        this.sage = sage;
    }
    
    public void move() {
        // 代码
        sage.move();
    }
//    public void eat() {
//    	sage.
//    }
}

//具体装饰角色“鱼儿”
class Fish extends Change {
    
    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // 代码
        System.out.println("Fish Move");
    }
}

//具体装饰角色“鸟儿”
class Bird extends Change {
    
    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        // 代码
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
