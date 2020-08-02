package io.github.hooj0.collection.list;

import io.github.hooj0.BasedTests;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试列表
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 7:46:19 PM
 */
public class ListTest extends BasedTests {

	public static void main(String[] args) {
		List<String> books = new ArrayList<String>();
		books.add("java");
		books.add("Java Web");
		books.add("Ajax 开发");
		books.add("struts");
		out(books);
		
		books.add(1, "RPC");
		for (int i = 0; i < books.size(); i++) {
			out(books.get(i));
		}
		
		books.remove(2);
		out(books);
		
		out(books.indexOf("RPC"));
		books.set(1, "RIA");
		out(books);
		out(books.subList(1, 3));
	}
}
