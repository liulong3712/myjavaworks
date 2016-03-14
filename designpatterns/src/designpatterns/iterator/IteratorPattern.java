package designpatterns.iterator;
import java.util.ArrayList;
import java.util.List;
/*
 * 迭代器模式
 */
interface Iterator {
	public Object next();
	public boolean hasNext();
}

class ConcreteIterator implements Iterator {

	private List<Object> list;
	private int cursor = 0;//当前游标位置
	public ConcreteIterator(List<Object> list) {
		this.list = list;
	}
	public Object next() {
		Object obj = null;
		if(hasNext()) {
			obj = list.get(cursor++);
		}
		return obj;
	}

	public boolean hasNext() {
		return !(cursor == list.size());
	}
	
}

//模拟集合接口 增删查
interface Aggregate {
	public void add(Object obj);
	public void remove(Object obj);
	public Iterator iterator();
}
class ConcreteAggregate implements Aggregate {
	private List<Object> list;
	public ConcreteAggregate(List<Object> list) {
		this.list = list;
	}
	public void add(Object obj) {
		list.add(obj);
	}

	public void remove(Object obj) {
		list.remove(obj);
	}

	public Iterator iterator() {
		return new ConcreteIterator(list);
	}
	
}
public class IteratorPattern {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("a");
		list.add("b");
		list.add("c");
		Aggregate aggregate = new ConcreteAggregate(list);
		Iterator iterator = aggregate.iterator();
		while(iterator.hasNext()) {
			String o = (String) iterator.next();
			System.out.println(o);
		}
	}

}
