package io.github.hooj0.io_nio.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 运行时输出流
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 13, 2010 1:11:12 PM
 */
public class RuntimeOutputStream {

	public static void main(String[] args) throws IOException {
		//运行java ReadStandard命令，返回该命令子进程
		Process p = Runtime.getRuntime().exec("java " + System.getProperty("user.dir") + "/src/com/hoo/io/stream/ReadStandard");
		//以p进程输出流创建PrintStream
		//这个输出流对本程序是输出流，对子进程是输入流
		PrintStream ps = new PrintStream(p.getOutputStream());
		//向ReadStandard程序写内容，内容将被ReadStandard读取
		ps.println("字符串一个");
		ps.println("this is temp string");
		ps.close();
	}
}

class ReadStandard {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new FileOutputStream(System.getProperty("user.dir") + "/file/out.txt"));
		sc.useDelimiter("\n");
		while (sc.hasNext()) {
			System.out.println("输入内容：" + sc.next());
		}
		ps.close();
	}
}
