package io.github.hooj0.io_nio.io.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	/**
	 *

	 * @createDate Dec 12, 2010 11:20:17 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		FileWriter fw = new FileWriter(path + "/file/fw.txt");//和文件编码有关系
		fw.write(new String("this is a string， 一个字符串".getBytes("UTF-8")));
		fw.write(new char[] { 'a', 'b', 'c' });
		fw.write(new String("窗前明月光，疑是地上霜".getBytes("gbk")));
		fw.flush();
		fw.close();
	}
}
