package io.github.hooj0.io.base;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class SystemInfo {

	/**
	 * <b>function:</b>

	 * @createDate Dec 12, 2010 4:34:36 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Properties pro = System.getProperties();
		Set<Entry<Object, Object>> s = pro.entrySet();
		Iterator<Entry<Object, Object>> iter = s.iterator();
		while(iter.hasNext()) {
			Entry<Object, Object> ety = iter.next();
			System.out.println(ety.getKey() + "##" + ety.getValue());
		}
		System.out.println("##########################");
		Set<Object> set = pro.keySet();
		for (Object o : set) {
			System.out.println(o + "=" + pro.getProperty(o.toString()) + "###" + pro.get(o));
		}
		System.out.println("##########################");
		Enumeration<Object> en = pro.keys();
		while(en.hasMoreElements()) {
			Object o = en.nextElement();
			System.out.println(o + "%%%" + pro.getProperty(o.toString()) + "###" + pro.get(o));
		}
		System.out.println("##########################");
		Enumeration<Object> ele = pro.elements();
		while(ele.hasMoreElements()) {
			Object o = ele.nextElement();
			System.out.println(o);
		}
		
		System.out.println("————————————————————————————————————");
		Collection<Object> v = pro.values();
		Iterator<Object> o = v.iterator();
		while(o.hasNext()) {
			Object value = o.next();
			System.out.println(value);
		}
	}
}
