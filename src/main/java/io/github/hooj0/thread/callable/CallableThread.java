package io.github.hooj0.thread.callable;

import java.util.concurrent.Callable;

/**
 * <b>function:</b>用Callable实现线程
 * @author hoojo
 * @createDate Nov 7, 2010 3:04:28 PM
 * @file CallableThread.java
 * @package com.hoo.thread.callable
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class CallableThread implements Callable<Integer> {
	//call方法作为线程的执行体
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + " 线程， i = " + i);
		}
		Thread.sleep(1500);
		return i;
	}
}
