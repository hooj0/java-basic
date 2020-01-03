package io.github.hooj0.collection.base;

import java.util.Collection;
import java.util.HashSet;

/**
 * 集合循环测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 4, 2011 8:49:09 PM
 */
public class ForeachCollectionTest {

	public static void main(String[] args) {
		Collection<String> books = new HashSet<String>();
		books.add("Java");
		books.add(".Net");
		books.add("php");
		
		for (String s : books) {
			System.out.println(s);
			if (s.equals(".Net")) {
				books.remove(s);
			}
		}
		System.out.println(books);
	}
}
