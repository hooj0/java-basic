package io.github.hooj0.collection.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PerformanceTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 10, 2011 10:59:40 PM
	 * @param args
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
	public static void main(String[] args) {
		String[] arr = new String[900000];
		for (int i = 0; i < 900000; i++) {
			arr[i] = String.valueOf(i);
		}
		
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < 900000; i++) {
			al.add(arr[i]);
		}
		
		LinkedList<String> ll = new LinkedList<String>();
		for (int i = 0; i < 900000; i++) {
			ll.add(arr[i]);
		}
		
		long start = System.currentTimeMillis();
		for (Iterator<String> iter = al.iterator(); iter.hasNext();) {
			iter.next();
		}
		System.out.println("迭代ArrayList集合元素的时间：" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		for (Iterator<String> iter = ll.iterator(); iter.hasNext();) {
			iter.next();
		}
		System.out.println("迭代LinkedList集合元素的时间：" + (System.currentTimeMillis() - start));
	}
}
