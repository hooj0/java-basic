package io.github.hooj0.io_nio.io.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeInputStream {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 1:01:00 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("javac");
		//p进程错误流创建BufferedReader对象
		//这个错误流对本程序是输入流，对p则是输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String content = null;
		while ((content = br.readLine()) != null) {
			System.out.println(content);
		}
		br.close();
	}
}
