package io.github.hooj0.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 9, 2011 7:46:19 PM
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> books = new ArrayList<String>();
		books.add("java");
		books.add("Java Web");
		books.add("Ajax 开发");
		books.add("struts");
		System.out.println(books);
		
		books.add(1, "RPC");
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
		
		books.remove(2);
		System.out.println(books);
		
		System.out.println(books.indexOf("RPC"));
		books.set(1, "RIA");
		System.out.println(books);
		System.out.println(books.subList(1, 3));
	}
}
