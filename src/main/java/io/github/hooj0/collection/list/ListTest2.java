package io.github.hooj0.collection.list;

import io.github.hooj0.BasedTests;

import java.util.ArrayList;
import java.util.List;

/**
 * test2列表
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 9:20:21 PM
 */
public class ListTest2 extends BasedTests {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add("struts");
		list.add("spring");
		list.add("hibernate");
		out(list);
		//equals为true就删除一个元素
		list.remove(new A());
		out(list);
		
		list.remove(new A());
		out(list);
	}
}

class A {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
