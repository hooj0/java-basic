package io.github.hooj0.io_nio.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertFileContent {
	
	public static void insert(String fileName, long pos, String insertContent) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		//临时文件保存插入点后面的内容
		File temp = File.createTempFile("tmp", null);
		FileOutputStream fos = new FileOutputStream(temp);
		FileInputStream fis = new FileInputStream(temp);
		raf.seek(pos);
		
		//读取插入点后面的内容，保存在临时文件中
		byte[] b = new byte[64];
		int len = 0;
		while ((len = raf.read(b)) > 0) {
			fos.write(b, 0, len);
		}
		
		//向文件中插入内容
		//把文件记录指针重新定位到pos位置
		raf.seek(pos);
		raf.write(insertContent.getBytes());
		
		//读取临时文件内容，追加内容
		while ((len = fis.read(b)) > 0) {
			raf.write(b, 0, len);
		}
		
		fis.close();
		fos.close();
		raf.close();
	}
	
	/**
	 *

	 * @createDate Dec 13, 2010 2:24:35 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		InsertFileContent.insert(path + "/file/temp.txt", 22, "|this is a insert content|");
	}
}
