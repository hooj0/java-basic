package io.github.hooj0.reflection.getclass;

import io.github.hooj0.BasedTests;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 6, 2010 2:43:30 PM
 */
public class ClassTest extends BasedTests {

	public static void main(String[] args) throws Exception {
		Class<?> clazz1 = Class.forName("java.util.Date");
		out(clazz1);

		Class<?> clazz2 = Date.class;
		Class<?> c = int[].class;
		out(c);
		out(clazz2);

		String name = "abcd";
		Class<?> clazz3 = name.getClass();
		out(clazz3);

		Class<?> clazz4 = SimpleDateFormat.class.getSuperclass();
		out(clazz4);

		Class<?> clazz5 = Boolean.TYPE;
		Class<?> clazz6 = Boolean.class;
		out((clazz5 == clazz6) + ":" + clazz5 + "," + clazz6);

		Class<?> clazz7 = ClassLoader.getSystemClassLoader().loadClass("java.util.Date");
		out(clazz7);
	}
}
