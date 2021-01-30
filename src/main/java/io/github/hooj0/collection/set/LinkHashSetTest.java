package io.github.hooj0.collection.set;

import java.util.LinkedHashSet;

public class LinkHashSetTest {

	/**
	 * 有序列表
	 * @author hoojo
	 * @createDate Jan 9, 2011 4:41:14 PM
	 * @param args
	 */
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
