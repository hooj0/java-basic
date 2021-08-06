package io.github.hooj0.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

	/**
	 *
	 * @author hoojo
	 * @createDate Jan 9, 2011 9:20:21 PM
	 * @param args
	 */
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("struts");
		list.add("spring");
		list.add("hibernate");
		System.out.println(list);
		//equals为true就删除一个元素
		list.remove(new A());
		System.out.println(list);
		
		list.remove(new A());
		System.out.println(list);
	}
}

class A {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
