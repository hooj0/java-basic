package io.github.hooj0.reflection.method;

import io.github.hooj0.BasedTests;

import java.lang.reflect.Array;

/**
 * 数组test2
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 6, 2010 3:40:30 PM
 */
public class ArrayTest2 extends BasedTests {

	public static void main(String[] args) {
		int[] doms = {3, 5, 4};
		Object arr = Array.newInstance(Integer.TYPE, doms);
		Object arrObj = Array.get(arr, 2);
		Class<?> clazz = arrObj.getClass().getComponentType();
		out(clazz);

		Object arrObject = Array.get(arrObj, 4);
		out(Array.getLength(arrObject));

		Array.set(arrObject, 3, 55);
		int[][][] array = (int[][][]) arr;
		out(array[2][4][3]);
	}
}
