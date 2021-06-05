package io.github.hooj0.reflection.method;

import io.github.hooj0.BasedTests;

import java.lang.reflect.Array;

/**
 * 数组test1
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 6, 2010 3:33:27 PM
 */
public class ArrayTest1 extends BasedTests {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("java.lang.String");
		Object arr = Array.newInstance(clazz, 10);
		int[] x = new int[]{1, 3, 4};
		int[] y = {2, 4, 5};
		out(x[1] + "," + x[0]);
		out(y[2]);

		Array.set(arr, 5, "array");
		Array.set(arr, 6, "loader");
		out(Array.get(arr, 5));

		String[] array = (String[]) arr;
		out(array[6]);
	}
}
