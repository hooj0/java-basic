package io.github.hooj0.reflection.method;

import java.lang.reflect.Array;

public class ArrayTest2 {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 6, 2010 3:40:30 PM
	 * @param args
	 */
	public static void main(String[] args) {
		int[] doms = {3, 5, 4};
		Object arr = Array.newInstance(Integer.TYPE, doms);
		Object arrObj = Array.get(arr, 2);
		Class<?> clazz = arrObj.getClass().getComponentType();
		System.out.println(clazz);                                                                  
		Object arrObject = Array.get(arrObj, 4);
		System.out.println(Array.getLength(arrObject));
		Array.set(arrObject, 3, 55);
		int[][][] array = (int[][][]) arr;
		System.out.println(array[2][4][3]);
	}
}
