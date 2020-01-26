package io.github.hooj0.generic.boxing;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 装箱拆箱
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 7, 2010 11:39:20 AM
 */
public class BoxCase {

	public static void main(String[] args) {
		int num = 12;
		Collection<Integer> c = new ArrayList<Integer>();
		//自动装箱: int -> Integer
		c.add(22);
		c.add(num + 5);
		//自动拆箱：Integer -> int
		for (int i : c) {
			System.out.println(i);
		}
	}
}
