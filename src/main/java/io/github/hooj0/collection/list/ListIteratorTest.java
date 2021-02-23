package io.github.hooj0.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 9, 2011 9:34:15 PM
	 * @param args
	 */
	public static void main(String[] args) {
		String[] books = { "Struts2", "JavaBase" };
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < books.length; i++) {
			list.add(books[i]);
		}
		
		ListIterator<String> iter = list.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			iter.add("=======");
			//System.out.println("##########");
		}
		System.out.println("==下面开始方向迭代==");
		while (iter.hasPrevious()) {
			//System.out.println(iter.previousIndex());
			System.out.println(iter.previous());
		}
	}
}
