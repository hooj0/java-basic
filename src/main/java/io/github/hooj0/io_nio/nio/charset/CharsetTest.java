package io.github.hooj0.io_nio.nio.charset;

import io.github.hooj0.BasedTests;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * 字符集测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 2, 2011 4:52:16 PM
 */
@SuppressWarnings("ALL")
public class CharsetTest extends BasedTests {

	public static void main(String[] args) {
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			out(alias + "#" + map.get(alias));
		}
	}
}
