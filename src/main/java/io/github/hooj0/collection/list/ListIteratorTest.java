package io.github.hooj0.collection.list;

import io.github.hooj0.BasedTests;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 列表迭代器测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 9:34:15 PM
 */
public class ListIteratorTest extends BasedTests {

	public static void main(String[] args) {
		String[] books = { "Struts2", "JavaBase" };
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < books.length; i++) {
			list.add(books[i]);
		}
		
		ListIterator<String> iter = list.listIterator();
		while (iter.hasNext()) {
			out(iter.next());
			iter.add("=======");
			//out("##########");
		}
		out("==下面开始方向迭代==");
		while (iter.hasPrevious()) {
			//out(iter.previousIndex());
			out(iter.previous());
		}
	}
}
