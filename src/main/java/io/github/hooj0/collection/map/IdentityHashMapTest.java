package io.github.hooj0.collection.map;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 13, 2011 10:37:40 PM
	 * @param args
	 * 普通的HashMap比较key相等是比较key的equals
	 * IdentifyHashMap是比较key的hashCode相等
	 */
	public static void main(String[] args) {
		IdentityHashMap<String, Integer> ihm = new IdentityHashMap<String, Integer>();
		ihm.put(new String("语文"), 89);
		ihm.put(new String("语文"), 78);//hashCode不等
		
		ihm.put("java", 99);
		ihm.put("java", 92);//hashCode相等
		
		System.out.println(ihm);
	}
}
