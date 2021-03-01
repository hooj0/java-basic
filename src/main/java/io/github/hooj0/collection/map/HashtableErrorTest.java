package io.github.hooj0.collection.map;

import java.util.Hashtable;
import java.util.Iterator;

public class HashtableErrorTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 12, 2011 10:21:22 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Hashtable<A, Object> tab = new Hashtable<A, Object>();
		tab.put(new A(60000), "java");
		tab.put(new A(87563), "struts");
		System.out.println(tab);
		Iterator<A> iter = tab.keySet().iterator();
		//取出第一个key
		A first = iter.next();
		first.count = 87563;
		System.out.println(tab);//2个对象的key相同
		
		tab.remove(new A(87563));//删除的是未被修改key对象（迭代出来的第一个A不能删除）
		System.out.println(tab);
		//无法取得value，都是null，因为key都被修改过
		System.out.println(tab.get(new A(87563)));
		System.out.println(tab.get(new A(60000)));
	}
	/**
	 * 在HashSet类似的是，尽量不要使用可变对象作为Hashtable、HashMap的key
	 * 如果一定需要要使用可变对象作为key，尽量不要在程序中修改key的可变变量
	 */
}
