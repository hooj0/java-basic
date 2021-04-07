package io.github.hooj0.io.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SystemInTest {

	/**
	 * <b>function:</b>

	 * @createDate Dec 13, 2010 12:34:22 PM
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path + "/file/temp.txt");
		//将标准输入重定向到fis输入流
		System.setIn(fis);
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");//回车等于\n
		while (sc.hasNext()) {
			System.out.println("输入内容：" + new String(sc.next().getBytes(), "utf-8"));
		}
		fis.close();
	}
}
