package designpatterns.factory;

/*
 * �򵥹���ģʽ
 * ʹ��ʵ��
 * һ��ũ����˾��ר�����г����۸���ˮ��ϵͳ����Ҫ��������ˮ��
 * 1ƻ��Apple
 * 2����Grape
 * 3��ݮStrawberry
 */

/*
 * Fruit�ࣺ
 */
interface Fruit {
    public void plant();
    public void grow();
    public void harverst();
}
/*
 * Apple�ࣺ
 */
class Apple implements Fruit {
    public void plant() {
        System.out.println("Plant apple.");
    }
    public void grow() {
        System.out.println("grow apple.");     
    }
    public void harverst() {
        System.out.println("harverst apple.");
    }
}
/*
 * Grape�����ࣺ
 */
class Grape implements Fruit {
    public void plant() {
        System.out.println("Plant Grape.");
    }
    public void grow() {
        System.out.println("grow Grape.");     
    }
    public void harverst() {
        System.out.println("harverst Grape.");
    }
}

/*
 * Strawberry��ݮ�ࣺ
 */
class Strawberry implements Fruit {
    public void plant() {
        System.out.println("Plant Strawberry.");
    }
    public void grow() {
        System.out.println("grow Strawberry.");     
    }
    public void harverst() {
        System.out.println("harverst Strawberry.");
    }
}

/*
 * FruitGardener�ࣺ(ˮ��)
 */
class FruitGardener {
    public static Fruit factory(String which){
        if(which.equals("apple")){
            return new Apple();
        }else if(which.equals("grape")){
            return new Grape();
        }else if(which.equals("strawberry")){
            return new Strawberry();
        }else{
            return null;
        }
    }
}
public class Simplefactory {

	public static void main(String[] args) {
		Fruit MyFruit = FruitGardener.factory("apple");
		MyFruit.grow();
		MyFruit = FruitGardener.factory("grape");
		MyFruit.grow();
		MyFruit = FruitGardener.factory("strawberry");
		MyFruit.grow();
	}

}
