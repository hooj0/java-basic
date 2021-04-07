package io.github.hooj0.nio.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * 字符集测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 09:12:12
 */
@SuppressWarnings("ALL")
public class CharsetTest {

	/**
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
