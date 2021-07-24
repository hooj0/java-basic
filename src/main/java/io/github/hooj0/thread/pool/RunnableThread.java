package io.github.hooj0.thread.pool;

/**
 * <b>function:</b>实现Runnable接口的线程
 * @author hoojo
 * @createDate Nov 7, 2010 5:14:55 PM
 * @file RunnableThread.java
 * @package com.hoo.thread.pool
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class RunnableThread implements Runnable {
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的i值是：" + i);
		}
	}
}
