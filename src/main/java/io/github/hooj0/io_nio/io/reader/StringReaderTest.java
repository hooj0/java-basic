package io.github.hooj0.io_nio.io.reader;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderTest {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 12:13:42 AM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String s = "这是一个字符串，this is a String";
		StringReader sr = new StringReader(s);
		char[] buffer = new char[32];
		int len = 0;
		while ((len = sr.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, len));
		}
		sr.close();
		
		//创建StringWriter时，实际上是以一个StringBuffer作为输出节点流
		//20表示就是StringBuffer的初始长度
		StringWriter sw = new StringWriter(20);
		sw.write("字符串一个");
		sw.write("is a String");
		System.out.println(sw.toString());
	}

}
