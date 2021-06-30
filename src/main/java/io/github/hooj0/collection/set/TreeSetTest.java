package io.github.hooj0.collection.set;

import java.util.Date;
import java.util.TreeSet;

public class TreeSetTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 9, 2011 4:48:46 PM
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Integer> n = new TreeSet<Integer>();
		n.add(5);
		n.add(2);
		n.add(10);
		n.add(-9);
		
		System.out.println(n);
		System.out.println(n.first());
		System.out.println(n.last());
		//返回小于4的子集
		System.out.println(n.headSet(4));
		//返回大于5的子集，如果set中包含5，子集中还包含5
		System.out.println(n.tailSet(4));
		//返回大于等于-3，小于4的子集
		System.out.println(n.subSet(-3, 4));
		
		//java.lang.ClassCastException试图向TreeSet中添加不同的对象类型
		//通过对象的compareTo完成比较
		TreeSet ts = new TreeSet();
		//ts.add(new Object());
		//ts.add(new Object());
		ts.add("JavaEE");
		ts.add(new Date());
	}
}
