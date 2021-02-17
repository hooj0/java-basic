package io.github.hooj0.thread.stream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * <b>function:</b>线程输出流
 * @author hoojo
 * @createDate Nov 6, 2010 6:49:53 PM
 * @file WriterThread.java
 * @package com.hoo.thread.stream
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class WriterThread extends Thread {
	private String[] books = {
			"a",
			"b",
			"c"
	}; 
	
	private PipedWriter pw;
	public WriterThread(PipedWriter pw) {
		this.pw = pw;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				pw.write(books[i % 4] + "\n");
			}
		} catch (Exception e) {
			
		} finally {
			if (pw != null) {
				try {
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PipedWriter pw = null;
		PipedReader pr = null;
		try {
			pw = new PipedWriter();
			pr = new PipedReader();
			//连接管道输入输出流
			pw.connect(pr);
			//将连接好的输入、输出流分别传入线程
			new ReaderThread(pr).start();
			//就可以让2个线程通过管道流通信
			new WriterThread(pw).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
