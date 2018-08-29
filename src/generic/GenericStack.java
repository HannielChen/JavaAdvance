package generic;

import java.util.ArrayList;
/**
 * 定义泛型类
 * 用Arraylist定义了一个泛型栈类
 */
public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	public int getSize() {
		return list.size();
	}
	
	public E peek() {
		return list.get(getSize()-1);		
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public E pop() {
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
