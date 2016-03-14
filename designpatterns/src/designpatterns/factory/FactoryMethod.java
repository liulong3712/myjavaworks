package designpatterns.factory;

/*
 * ��������ģʽ
 */

/*
 * ��Ʒ����ӿ�
 */
interface Product
{
	public void show();
}

/*
 * ��������ӿ�
 */
interface Creator
{
   public Product CreateProduct();
}

class ConcreteProduct1 implements Product
{
    public void show() {
		System.out.println("���ǲ�ƷConcreteProduct1");
	}

	public ConcreteProduct1()
    {
       System.out.println("ConcreteProduct1������");
    }
}

class ConcreteProduct2 implements Product
{
    public void show() {
    	System.out.println("���ǲ�ƷConcreteProduct2");
		
	}

	public ConcreteProduct2()
    {
        System.out.println("ConcreteProduct2������");
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
