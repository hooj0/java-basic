package io.github.hooj0.network.urlcode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLCodeTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		//将普通字符串转换成application/x-www-form-urlencoded
		String keyWord = URLEncoder.encode("中国", "UTF-8");
		System.out.println(keyWord);
		
		//将application/x-www-form-urlencoded字符串转换成普通字符前
		String encode = URLDecoder.decode(keyWord, "UTF-8");
		System.out.println(encode);
	}

}
