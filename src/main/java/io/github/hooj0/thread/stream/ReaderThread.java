package io.github.hooj0.thread.stream;

import java.io.BufferedReader;
import java.io.PipedReader;

/**
 * <b>function:</b>线程输入流
 * @author hoojo
 * @createDate Nov 6, 2010 6:49:05 PM
 * @file ReaderThread.java
 * @package com.hoo.thread.stream
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ReaderThread extends Thread {
	//private PipedReader pr;
	//创建包装管道流的Buffer对象
	private BufferedReader br;
	
	public ReaderThread(PipedReader pr) {
		//this.pr = pr;
		this.br = new BufferedReader(pr);
	}
	
	public void run() {
		String bf = null;
		try {
			while ((bf = br.readLine()) != null) {
				System.out.println(bf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
