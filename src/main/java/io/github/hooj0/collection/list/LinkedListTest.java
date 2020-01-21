package io.github.hooj0.collection.list;

import io.github.hooj0.BasedTests;

import java.util.LinkedList;

/**
 * 链表测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 10, 2011 10:17:30 PM
 */
public class LinkedListTest extends BasedTests {

	public static void main(String[] args) {
		LinkedList<String> books = new LinkedList<String>();
		//加入字符串到队里尾部
		books.offer("Struts2");
		//将一个字符串入栈
		books.push("Java");
		//添加元素到队里头部
		books.offerFirst("RIA");
		for (int i = 0; i < books.size(); i++) {
			out(books.get(i));
		}
		//访问并不删除队列的第一个元素
		out(books.peekFirst());
		//访问并不删除队列的最后个元素
		out(books.peekLast());
		//采用出栈方式将第一个栈pop出列
		out(books.pop());
		out(books);
		//访问、并删除最后一个元素
		out(books.pollLast());
		out(books);
	}
	/**
	 * ArrayList/Vector内部采用数组的形式保存集合中的元素
	 * 因此随机访问集合上的元素有较好的性能
	 * 而LinkedList内部以链表的形式来保存集合中的元素
	 * 因此随机访问集合元素时性能较差
	 * 但插入的时候性能比较好（改变指针即可）
	 * Vector实现了线程同步功能，性能较差
	 * 
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 				实现机制			随机访问排名	迭代操作排名	插入操作排名	删除操作排名
	 * ----------------------------------------------------------------------------
	 * 数组			连续内存区域保存元素	1			X		X				X
	 * ----------------------------------------------------------------------------
	 * ArrayList	内部以数组保存元素		2			2		2				2
	 * ----------------------------------------------------------------------------
	 * Vector		内部以数组保存元素		3			3		3				3
	 * ----------------------------------------------------------------------------
	 * LinkedList	内部以链表保存元素		4			1		1				1
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
}
