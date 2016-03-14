package designpatterns.template;

/*
 * ģ�巽��ģʽ
 */

/// ������
/// </summary>
abstract class AbstractClass
{
    // һЩ������Ϊ���ŵ�����ȥʵ��
    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();

    /// <summary>
    /// ģ�巽�����������߼��ĹǼܣ����߼��������һЩ��Ӧ�ĳ�������������Ƴٵ�����ȥʵ�֡�
    /// </summary>
    public void TemplateMethod()
    {
        PrimitiveOperation1();
        PrimitiveOperation2();
        System.out.println("Done the method.");
    }
}

/// <summary>
/// �����࣬ʵ���˳������е��ض�����
/// </summary>
class ConcreteClassA extends AbstractClass
{
    /// <summary>
    /// ��ConcreteClassB�е�ʵ���߼���ͬ
    /// </summary>
    public void PrimitiveOperation1()
    {
    	System.out.println("Implement operation 1 in Concreate class A.");
    }

    /// <summary>
    /// ��ConcreteClassB�е�ʵ���߼���ͬ
    /// </summary>
    public void PrimitiveOperation2()
    {
    	System.out.println("Implement operation 2 in Concreate class A.");
    }
}

/// <summary>
/// �����࣬ʵ���˳������е��ض�����
/// </summary>
class ConcreteClassB extends AbstractClass
{
    /// <summary>
    /// ��ConcreteClassA�е�ʵ���߼���ͬ
    /// </summary>
    public void PrimitiveOperation1()
    {
    	System.out.println("Implement operation 1 in Concreate class B.");
    }

    /// <summary>
    /// ��ConcreteClassA�е�ʵ���߼���ͬ
    /// </summary>
    public void PrimitiveOperation2()
    {
    	System.out.println("Implement operation 2 in Concreate class B.");
    }
}
public class Template {

	public static void main(String[] args) {
		// ����������
        AbstractClass c;

        // ��ConcreteClassAʵ����c
        c = new ConcreteClassA();
        c.TemplateMethod();

        // ��ConcreteClassBʵ����c
        c = new ConcreteClassB();
        c.TemplateMethod();

	}

}
