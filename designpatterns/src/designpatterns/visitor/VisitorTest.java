package designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 访问者模式
 */
interface Element{
	public void accept(Visitor vistor);
}
class ConcreteElementA implements Element{

	public void accept(Visitor vistor) {
		vistor.vist(this);
		System.out.println("访问元素A");
	}
}
class ConcreteElementB implements Element{

	public void accept(Visitor vistor) {
		vistor.vist(this);
		System.out.println("访问元素B");
	}
}
class ConcreteElementC implements Element{

	public void accept(Visitor vistor) {
		vistor.vist(this);
		System.out.println("访问元素C");
	}
}
class ObjectStructure{
	private ArrayList<Element> list = new ArrayList<Element>();
	public void accept(Visitor vistor){
		Iterator i = list.iterator();
		while(i.hasNext()){
			((Element)i.next()).accept(vistor);
		}
	}
	public void addElement(Element element){
		list.add(element);
	}
	public void removeElement(Element element){
		list.remove(element);
	}
}
abstract class Visitor{
	public abstract void vist(ConcreteElementA elementA);
	public abstract void vist(ConcreteElementB elementB);
	public abstract void vist(ConcreteElementC elementC);
}
class VisitorA extends Visitor{

	@Override
	public void vist(ConcreteElementA elementA) {
		System.out.print("访问者A访问");
	}

	@Override
	public void vist(ConcreteElementB elementB) {
		System.out.print("访问者A访问");
	}

	@Override
	public void vist(ConcreteElementC elementC) {
		System.out.print("访问者A访问");
	}
}
class VisitorB extends Visitor{

	@Override
	public void vist(ConcreteElementA elementA) {
		System.out.print("访问者B访问");
	}

	@Override
	public void vist(ConcreteElementB elementB) {
		System.out.print("访问者B访问");
	}

	@Override
	public void vist(ConcreteElementC elementC) {
		System.out.print("访问者B访问");
	}
}
public class VisitorTest {

	public static void main(String[] args) {
		ObjectStructure myObjectStructure = new ObjectStructure();
		ConcreteElementA concreteelementA = new ConcreteElementA();
		ConcreteElementB concreteelementB = new ConcreteElementB();
		ConcreteElementC concreteelementC = new ConcreteElementC();
		VisitorA visitora = new VisitorA();
		VisitorB visitorb = new VisitorB();
		myObjectStructure.addElement(concreteelementA);
		myObjectStructure.addElement(concreteelementB);
		myObjectStructure.addElement(concreteelementC);
		myObjectStructure.accept(visitora);
		myObjectStructure.accept(visitorb);
	}

}
