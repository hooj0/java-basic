package io.github.hooj0.generic.boxing;

import java.util.HashMap;
import java.util.Map;

public class AddCount {

	/**
	 *
	 * @author hoojo
	 * @createDate Oct 7, 2010 11:45:19 AM
	 * @param args
	 */
	public static void main(String[] args) {
		String stat = "if it is to be it is up to me to do the watusi";
		String[] words = stat.split(" ");
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (String word : words) {
			/**
			 * 这里用到了自动装箱和拆箱，put(word, 1);是装箱
			 * m.get(word) + 1是拆箱， m.get(word) is a Object
			 */
			m.put(word, (m.containsKey(word) ? (m.get(word) + 1) : 1));
		}
		System.out.println(m);
	}
}
