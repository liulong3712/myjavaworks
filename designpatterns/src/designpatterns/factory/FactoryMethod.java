package designpatterns.factory;

/*
 * 工厂方法模式
 */

/*
 * 产品抽像接口
 */
interface Product
{
	public void show();
}

/*
 * 工厂抽象接口
 */
interface Creator
{
   public Product CreateProduct();
}

class ConcreteProduct1 implements Product
{
    public void show() {
		System.out.println("我是产品ConcreteProduct1");
	}

	public ConcreteProduct1()
    {
       System.out.println("ConcreteProduct1被创建");
    }
}

class ConcreteProduct2 implements Product
{
    public void show() {
    	System.out.println("我是产品ConcreteProduct2");
		
	}

	public ConcreteProduct2()
    {
        System.out.println("ConcreteProduct2被创建");
    }
 
}

class ConcreteCreator1 implements Creator
{
   public Product CreateProduct()
   {
       return new ConcreteProduct1();
   }
}

class ConcreteCreator2 implements Creator
{
   public Product CreateProduct()
   {
      return new ConcreteProduct2();
   }
}


public class FactoryMethod {
	private static Creator creator1, creator2;
    @SuppressWarnings("unused")
	private static Product prod1, prod2;
	public static void main(String[] args) {
		creator1 = new ConcreteCreator1();
        prod1 = creator1.CreateProduct();
        System.out.println("----------------------------");
        creator2 = new ConcreteCreator2();
        prod2 = creator2.CreateProduct();
        prod2.show();
	}

}
