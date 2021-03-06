package io.github.hooj0.io_nio.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 系统测试
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 13, 2010 12:26:36 PM
 */
public class SystemOutTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String path = System.getProperty("user.dir");
		
		//创建输出流
		PrintStream ps = new PrintStream(new FileOutputStream(path + "/file/out.txt"));
		//将标准输出重定向到PrintStream的输出
		System.setOut(ps);
		//向标准输出中输出写内容
		System.out.println(new String("输出的内容".getBytes("utf-8")));
		System.out.println(ps);
		ps.close();
	}
}
