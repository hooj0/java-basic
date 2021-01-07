package io.github.hooj0.io_nio.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

	/**
	 * 

	 * @createDate Dec 12, 2010 11:36:22 PM
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * 用PrintStream包装FileOutputStream
		 */
		String path = System.getProperty("user.dir");
		FileOutputStream fos = new FileOutputStream(path + "/file/temp1.txt");
		//用PrintStream包装FileOutputStream
		PrintStream ps = new PrintStream(fos);
		//使用PrintStream执行输出
		ps.println("输出数据");
		ps.println(fos);
		ps.flush();
		ps.close();
		/*
		 * PrintStream功能非常强大，适合输出大量文本数据
		 * System.out就是PrintStream类型的
		 * 
		 * 当我们用处理流来包装底层节点流之后，关闭输入、输出流资源时，
		 * 只要关闭最上层的处理流即可
		 */
	}
}
