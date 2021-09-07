package io.github.hooj0.collection.base;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class EnumerationTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 14, 2011 10:23:02 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("Struts2");
		v.add("Java");
		
		Hashtable<String, Integer> scores = new Hashtable<String, Integer>();
		scores.put("语文", 99);
		scores.put("数学", 89);
		scores.put("英语", 78);
		Enumeration<String> em = v.elements();
		while (em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
		
		Enumeration<String> keyem = scores.keys();
		while (keyem.hasMoreElements()) {
			String key = keyem.nextElement();
			System.out.print(key + "--->");
			System.out.println(scores.get(key));
		}
	}
}
