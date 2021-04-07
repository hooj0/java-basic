package io.github.hooj0.io.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamTest {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 12:10:15 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		//创建字节输入流
		FileInputStream fis = new FileInputStream(path + "/file/temp1.txt");
		PushbackInputStream pis = new PushbackInputStream(fis, 128 * 2);
		//创建一个长度1024的数组
		byte[] bf = new byte[128];
		String read = "";
		int len = 0;
		while ((len = pis.read(bf)) > 0) {
			//将读取的内容转换成字符串
			String content = new String(bf, 0, len);
			System.out.println("当前：" + content);
			//将上次读取的内容和当前读取的内容拼接起来，查看是否含有目标字符串
			int targetIndex = 0;
			String text = read + content;
			if ((targetIndex = (text).indexOf("new PushbackReader")) > 0) {
				System.out.println("被推回的内容：【" + text + "】");
				//将本次内人和上次的内容一起推回到缓冲区
				pis.unread(text.getBytes());
				//再次读取指定长度的内容（就是目标字符串之前的内容）
				System.out.println(targetIndex - 2);
				//bf = new byte[text.length()];
				pis.read(bf, 0, bf.length);
				System.out.println("之前:" + new String(bf, 0, bf.length));
				System.exit(1);
			} else {
				//输出上次内容
				System.out.println("上次：" + read);
				//本次读取内容设为上次读取的内容
				read = content;
			}
		}
		pis.close();
		fis.close();
	}

}
