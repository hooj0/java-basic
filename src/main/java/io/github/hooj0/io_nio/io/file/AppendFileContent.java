package io.github.hooj0.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendFileContent {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 2:05:31 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		//以读写的方式打开文件
		RandomAccessFile raf = new RandomAccessFile(path + "/file/out.txt", "rw");
		//将记录指针移动到out.txt文件最后
		raf.seek(raf.length());
		raf.write("追加的内容\r\n".getBytes("utf-8"));
		raf.writeUTF("utf内容");
		raf.close();
	}
	/**
	 * RandomAccessFile还是不能随意向文件插入内容，如果要在一段文本
	 * 中插入内容，插入的内容将会覆盖掉后面的内容；
	 * 所以在插入内容的时候，需要先读取插入内容位置后面的内容到缓冲区
	 * 然后在插入内容，然后将缓冲区中的内容追加到文件中即可
	 */
}
