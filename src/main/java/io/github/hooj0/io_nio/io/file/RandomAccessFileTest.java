package io.github.hooj0.io_nio.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	/**
	 *

	 * @createDate Dec 13, 2010 1:53:48 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		//以只读的方式打开指定文件
		RandomAccessFile raf = new RandomAccessFile(path + "/src/com/hoo/io/file/RandomAccessFileTest.java", "r");
		//获取raf的初始指针位置
		System.out.println("初始指针位置：" + raf.getFilePointer());
		//移动raf的文件记录指针位置
		raf.seek(200);
		byte[] buff = new byte[1024];
		//用于保存实际读取字节数
		int len = 0;
		while ((len = raf.read(buff)) > 0) {
			System.out.println(new String(buff, 0, len));
			System.out.println(new String(buff, "utf-8"));
		}
		raf.close();
	}
}
