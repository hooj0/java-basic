package io.github.hooj0.collection.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {

	/**
	 *
	 * @author hoojo
	 * @createDate Jan 4, 2011 8:29:09 PM
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个集合
		Collection<String> books = new HashSet<String>();
		books.add("java");
		books.add("java Servlet");
		books.add("Struts");
		
		Iterator<String> iter = books.iterator();
		while (iter.hasNext()) {
			String book = iter.next();
			System.out.println(book);
			if (book.equals("Struts")) {
				//从集合中删除上一次next方法返回的元素
				iter.remove();
				//引发java.util.ConcurrentModificationException，不可修饰集合元素 
				//集合在循环迭代的时候是不能删除的 因为这样会改变迭代的元素的索引
				//books.remove(book);
			}
			//对book变量赋值，不影响集合
			book = "abc";
		}
		System.out.println(books);
	}
}
