package io.github.hooj0.io.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	/**
	 * <b>function:</b>

	 * @createDate Dec 12, 2010 11:11:00 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		FileOutputStream fos = new FileOutputStream(path + "/file/write.txt");
		String s = "写入文件中的内容";
		fos.write(s.getBytes("utf-8"));//文件保存编码UTF-8
		fos.write("is a temp file".getBytes("utf-8"));//文件保存编码UTF-8
		fos.write("乱码的字符串".getBytes());//文件保存编码UTF-8
		fos.flush();
		fos.close();//关闭流可以保证在缓冲区中的内容写入到物理文件中
	}
}
