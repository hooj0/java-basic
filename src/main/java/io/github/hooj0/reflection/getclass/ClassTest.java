package io.github.hooj0.reflection.getclass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassTest {

	/**
	 *
	 * @author hoojo
	 * @createDate Oct 6, 2010 2:43:30 PM
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class<?> clazz1 = Class.forName("java.util.Date");
		System.out.println(clazz1);
		Class<?> clazz2 = Date.class;
		Class<?> c = int[].class;
		System.out.println(c);
		System.out.println(clazz2);
		String name = "abcd";
		Class<?> clazz3 = name.getClass();
		System.out.println(clazz3);
		Class<?> clazz4 = SimpleDateFormat.class.getSuperclass();
		System.out.println(clazz4);
		Class<?> clazz5 = Boolean.TYPE;
		Class<?> clazz6 = Boolean.class;
		System.out.println((clazz5 == clazz6) + ":" + clazz5 + "," + clazz6);
		Class<?> clazz7 = ClassLoader.getSystemClassLoader().loadClass("java.util.Date");
		System.out.println(clazz7);
	}
}
