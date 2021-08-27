package io.github.hooj0.io_nio.io.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入流读取器测试
 *
 * @author hoojo
 * @version 1.0
 * @date Dec 13, 2010 12:28:56 AM
 */
public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		/*
		 * System.in包装成BufferedReader，bufferedReader具有一个缓冲功能
		 * 一次读取一行文本，直到读到换行字才输出数据，没有读到换行将阻塞，直到读到换行符为真
		 */
		String buffer = null;
		while ((buffer = br.readLine()) != null) {
			if (buffer.equals("exit")) {
				System.exit(1);
			}
			System.out.println("输入内容：" + buffer);
		}
		br.close();
	}
}
