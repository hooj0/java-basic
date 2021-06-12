package io.github.hooj0.generic.boxing;

import java.util.ArrayList;
import java.util.Collection;

public class BoxCase {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 7, 2010 11:39:20 AM
	 * @param args
	 */
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
