package io.github.hooj0.io_nio.io.reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	/**
	 *

	 * @createDate Dec 12, 2010 7:35:50 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		FileReader fr = null;
		try {
			//创建字节输入流
			fr = new FileReader(path + "/file/temp1.txt");
			//创建一个长度为32的杯子
			char[] c = new char[32];
			//用于保存实际读取的数据长度
			int len = 0;
			//重复舀水
			while ((len = fr.read(c)) > 0) {
				//取出数组中的数据
				System.out.println(new String(c, 0, len));
				System.out.println(new String(c));//读取不够的用字符“口”代替
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				fr.close();
			}
		}
	}
	
	/*
	 *移动指针操作：
	 	void mark(int readAheadLimit): 在记录指针当前位置第一个标记（mark）
		boolean markSupported(): 判断此输入流是否支持mark()操作，即是否支持记录标记
		void reset()：将此流的记录的指针重新定位到上一次记录的标记的位置
		long skip(long n)：记录指针向前移动n个字节、字符
	  
	  读取数据操作：
	 	int read(): 从输入流中读取单个字符
		int read(char[] c): 从输入流读取最多c.length个字符数据，并将其存储在字符数组c中，返回实际读取的字符
		int read(char[] c, int off, int len): 从输入流中读取最多len个字符的数据，将读取的数据放到字符数组c中保存，从数组的off开始读取；
	 */
}
