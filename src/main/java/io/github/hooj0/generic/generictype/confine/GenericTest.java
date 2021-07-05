package io.github.hooj0.generic.generictype.confine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@SuppressWarnings("ALL")
public class GenericTest<T> {
	private T foo;

	public T getFoo() {
		return foo;
	}

	public void setFoo(T foo) {
		this.foo = foo;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		GenericTest<ArrayList<String>> arrList = new GenericTest<ArrayList<String>>();
		arrList.setFoo(new ArrayList<String>());
		GenericTest<LinkedList<String>> linkList = new GenericTest<LinkedList<String>>();
		linkList.setFoo(new LinkedList<String>());
		//arrList = linkList;
		
		GenericTest<? extends List> arrList2 = new GenericTest<ArrayList<String>>();
		//arrList2.setFoo(new LinkedList());
		arrList2 = new GenericTest<LinkedList<Integer>>();
		//arrList2.setFoo(new LinkedList<Integer>());
		arrList2.setFoo(null);
		arrList2 = linkList;
		System.out.println(arrList2.getFoo());
		arrList2 = arrList;
		System.out.println(arrList2);
		
		//arrList2 = new GenericTest<HashSet<String>>();
		//实现ArrayList的父类，也就是实现List
		GenericTest<? super ArrayList<String>> gt = null;
		gt = new GenericTest<ArrayList<String>>();
		System.out.println(gt);
		//gt = new GenericTest<Set<String>>();
		GenericTest<? super List<?>> gt2 = null;
		//gt2 = (GenericTest<? super List<?>>) new GenericTest<SimpleCollection<String>>();
		System.out.println(gt2);
		gt2 = new GenericTest<Object>();
		System.out.println(gt2);
		
		GenericTest<String> g = new GenericTest<String>();
		g.setFoo("hello world");
		
		GenericTest<? extends Object> g2 = g;
		System.out.println(g2.getFoo());
		//g2.setFoo("zzzz");
		g2.setFoo(null);
		System.out.println(g2.getFoo());
		//g2.setFoo("yes !");
		/**
		 * 使用<?>或是<? extends SomeClass>的声明方式，
		 * 意味著您只能通过该名称来取得所参考实例的信息，
		 * 或者是移除某些信息，但不能增加它的信息，
		 * 因为只知道当中放置的是SomeClass的子类，
		 * 但不确定是什么类的实例，编译器不让您加入信息，
		 * 理由是，如果可以加入信息的話，
		 * 那么您就得記得取回的实例是什么类型，
		 * 然后转换为原來的类型方可进行操作，
		 * 这就失去了使用泛型的意义。
		 */
	}
}
