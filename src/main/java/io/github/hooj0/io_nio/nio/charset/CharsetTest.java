package io.github.hooj0.io_nio.nio.charset;

import io.github.hooj0.BasedTests;

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
public class CharsetTest extends BasedTests {

	/**
	 * @author hoojo
	 * @createDate Jan 2, 2011 4:52:16 PM
	 * @param args
	 */
	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			out(alias + "#" + map.get(alias));
		}
	}
}
