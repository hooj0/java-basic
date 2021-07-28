package io.github.hooj0.io_nio.io.reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackReaderTest {

	/**
	 *

	 * @createDate Dec 13, 2010 11:27:01 AM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		//创建一个推回输入流，推回缓冲区的长度是64
		PushbackReader pbr = new PushbackReader(new FileReader(path + "/file/temp1.txt"), 64);
		char[] c = new char[32];
		String read = null;
		int len = 0;
		while ((len = pbr.read(c)) > 0) {
			//将读取的内容转换成字符串
			String content = new String(c, 0, len);
			System.out.println("当前：" + content);
			//将上次读取的内容和当前读取的内容拼接起来，查看是否含有目标字符串
			int targetIndex = 0;
			String text = read + content;
			if ((targetIndex = (text).indexOf("new PushbackReader")) > 0) {
				System.out.println("被推回的内容：【" + text + "】");
				//将本次内人和上次的内容一起推回到缓冲区
				pbr.unread(text.toCharArray());
				//再次读取指定长度的内容（就是目标字符串之前的内容）
				System.out.println(targetIndex - 2);
				c = new char[text.length()];
				pbr.read(c, 0, c.length);
				System.out.println("之前:" + new String(c, 0, c.length));
				System.exit(1);
			} else {
				//输出上次内容
				System.out.println("上次：" + read);
				//本次读取内容设为上次读取的内容
				read = content;
			}
		}
		pbr.close();
	}
}
