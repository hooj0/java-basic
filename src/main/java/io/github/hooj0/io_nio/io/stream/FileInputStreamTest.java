package io.github.hooj0.io_nio.io.stream;

import io.github.hooj0.BasedTests;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件输入流测试
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 12, 2010 7:12:00 PM
 */
public class FileInputStreamTest extends BasedTests {

	/**
	 * 输入流InputStream
	 * FileInputStream 节点流，会直接和指定的文件关联
	 * @createDate Dec 12, 2010 7:12:00 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		//创建字节输入流
		FileInputStream fis = new FileInputStream(path + "/file/temp1.txt");
		//创建一个长度1024 * 8 的数组
		byte[] bf = new byte[1024 * 8];
		//保存实际读取的字节数
		int len = 0;
		while ((len = fis.read(bf)) > 0) {
			//提取数组中的数据
			out(new String(bf, 0, len));//temp1 gbk保存编码
			out(new String(bf));//temp1 gbk保存编码
			out(new String(bf, "gbk"));//temp保存编码UTF-8
		}
		//关闭输入流，这样垃圾回收才能回收资源
		fis.close();
	}
	/**
	 * 如果乱码和文件保存的编码有关系，中文编码gbk
	 * 如果读取的数组的数据，读取一次正好读取中文字符的一半
	 * 中文一个字2个字符
	 * 这样就造成乱码
	 * 
	 * int read(): 从输入流中读取单个字节
		int read(byte[] b): 从输入流中读取最多b.length个字节，将读取的字节存在数组b中，返回实际读取的字节数
		int read(byte[] b, int off, int len): 从输入流中读取最多len个字节数据，并将其存储在数字b中，放入b数组中时，并不是从数组起点开始，而是从off位置开始，返回实际读取字节数。
	
		移动指针操作：
		 	void mark(int readAheadLimit): 在记录指针当前位置第一个标记（mark）
			boolean markSupported(): 判断此输入流是否支持mark()操作，即是否支持记录标记
			void reset()：将此流的记录的指针重新定位到上一次记录的标记的位置
			long skip(long n)：记录指针向前移动n个字节、字符
	 */
}
