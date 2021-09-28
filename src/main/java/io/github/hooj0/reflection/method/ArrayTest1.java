package io.github.hooj0.reflection.method;

import java.lang.reflect.Array;

public class ArrayTest1 {

	/**
	 * 
	 * @author hoojo
	 * @createDate Oct 6, 2010 3:33:27 PM
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("java.lang.String");
		Object arr = Array.newInstance(clazz, 10);
		int[] x = new int[]{1, 3, 4};
		int[] y = {2, 4, 5};
		System.out.println(x[1] + "," + x[0]);
		System.out.println(y[2]);
		Array.set(arr, 5, "array");
		Array.set(arr, 6, "loader");
		System.out.println(Array.get(arr, 5));
		String[] array = (String[]) arr;
		System.out.println(array[6]);
	}
}
