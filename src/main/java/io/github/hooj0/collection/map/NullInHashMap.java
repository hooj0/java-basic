package io.github.hooj0.collection.map;

import java.util.HashMap;

/**
 * 零在散列映射
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 12, 2011 9:38:42 PM
 */
public class NullInHashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(null, null);
		map.put(null, null);//key重复，不能加入
		
		map.put("key", null);//value重复不会出现异常
		map.put("key", null);//无法加入
		System.out.println(map);
	}
	/**
	 * Hashtable 和 HashMap区别：
	 * 1、Hashtable是一个线程安全的Map实现，但HashMap是线程不安全的实现，
	 * 所以HashMap比Hashtable的性能高一点；但当有多个线程访问同一个Map的时候
	 * 使用Hashtable较安全
	 * 2、Hashtable不允许使用null作为key和value，如果试图把null值放进Hashtable中
	 * 将会引发NullPointerException异常，但HashMap可以放null的key、value
	 * HashMap的key不允许重复
	 */
}
