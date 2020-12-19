package io.github.hooj0.collection.set;

import java.util.LinkedHashSet;

/**
 * 有序列表 链接散列集测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 4:41:14 PM
 */
public class LinkHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet<String> books = new LinkedHashSet<String>();
		books.add("Java");
		books.add("Struts");
		System.out.println(books);
		books.remove("Struts");
		System.out.println(books);
		books.add("Struts");
		System.out.println(books);
	}
}
