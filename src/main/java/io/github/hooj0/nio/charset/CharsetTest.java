package io.github.hooj0.nio.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 2, 2011 4:52:16 PM
	 * @param args
	 */
	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			System.out.println(alias + "#" + map.get(alias));
		}
	}
}
