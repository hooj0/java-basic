package io.github.hooj0.classloader.instance;

import java.lang.reflect.Array;

public class MyArray {
	
	@SuppressWarnings("unchecked")
	public static <T> T[] newInstance(Class<T> componentType, int length) {
		return (T[]) Array.newInstance(componentType, length);
	}
	
	/**
	 *
	 * @author hoojo
	 * @createDate Oct 5, 2010 1:59:23 PM
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = MyArray.newInstance(String.class, 10);
		arr[5] = "abc";
		int[][] intArr = MyArray.newInstance(int[].class, 10);
		intArr[1] = new int[] {1, 2};
		System.out.println(arr[5]);
		System.out.println(intArr[1][1]);
		System.out.println(intArr[1][0]);
	}
}
