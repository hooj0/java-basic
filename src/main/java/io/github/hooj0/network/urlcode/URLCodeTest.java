package io.github.hooj0.network.urlcode;

import io.github.hooj0.BasedTests;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * urlcode 测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 15:08:36
 */
public class URLCodeTest extends BasedTests {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//将普通字符串转换成application/x-www-form-urlencoded
		String keyWord = URLEncoder.encode("中国", "UTF-8");
		out(keyWord);
		
		//将application/x-www-form-urlencoded字符串转换成普通字符前
		String encode = URLDecoder.decode(keyWord, "UTF-8");
		out(encode);
	}
}
