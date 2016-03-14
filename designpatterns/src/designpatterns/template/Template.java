package designpatterns.template;

/*
 * 模板方法模式
 */

/// 抽象类
/// </summary>
abstract class AbstractClass
{
    // 一些抽象行为，放到子类去实现
    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();

    /// <summary>
    /// 模板方法，给出了逻辑的骨架，而逻辑的组成是一些相应的抽象操作，它们推迟到子类去实现。
    /// </summary>
    public void TemplateMethod()
    {
        PrimitiveOperation1();
        PrimitiveOperation2();
        System.out.println("Done the method.");
    }
}

/// <summary>
/// 具体类，实现了抽象类中的特定步骤
/// </summary>
class ConcreteClassA extends AbstractClass
{
    /// <summary>
    /// 与ConcreteClassB中的实现逻辑不同
    /// </summary>
    public void PrimitiveOperation1()
    {
    	System.out.println("Implement operation 1 in Concreate class A.");
    }

    /// <summary>
    /// 与ConcreteClassB中的实现逻辑不同
    /// </summary>
    public void PrimitiveOperation2()
    {
    	System.out.println("Implement operation 2 in Concreate class A.");
    }
}

/// <summary>
/// 具体类，实现了抽象类中的特定步骤
/// </summary>
class ConcreteClassB extends AbstractClass
{
    /// <summary>
    /// 与ConcreteClassA中的实现逻辑不同
    /// </summary>
    public void PrimitiveOperation1()
    {
    	System.out.println("Implement operation 1 in Concreate class B.");
    }

    /// <summary>
    /// 与ConcreteClassA中的实现逻辑不同
    /// </summary>
    public void PrimitiveOperation2()
    {
    	System.out.println("Implement operation 2 in Concreate class B.");
    }
}
public class Template {

	public static void main(String[] args) {
		// 声明抽象类
        AbstractClass c;

        // 用ConcreteClassA实例化c
        c = new ConcreteClassA();
        c.TemplateMethod();

        // 用ConcreteClassB实例化c
        c = new ConcreteClassB();
        c.TemplateMethod();

	}

}
