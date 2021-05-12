package io.github.hooj0.thread.base;

import java.util.Date;

/**
 * <b>function:</b>线程休眠
 * @author hoojo
 * @createDate Nov 6, 2010 6:40:27 PM
 * @file SleepThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class SleepThread {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 31, 2010 5:10:18 PM
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("time:" + new Date());
			Thread.sleep(1000);//暂停1秒，1秒后继续运行（间隔1秒）
		}
	}
}
