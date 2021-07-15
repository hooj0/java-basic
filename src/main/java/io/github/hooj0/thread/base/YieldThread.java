package io.github.hooj0.thread.base;

/**
 * yield线程
 * @author hoojo
 * @createDate Oct 31, 2010 5:12:16 PM
 * @file YieldThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class YieldThread extends Thread {
	
	public YieldThread(){
	}
	
	public YieldThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + "#" + i);
			if (i == 20) {
				Thread.yield();
			}
		}
	}
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Oct 31, 2010 5:22:16 PM
	 * @param args
	 */
	public static void main(String[] args) {
		// 启动2条并发进程
		YieldThread advanced = new YieldThread("高级");
		// 将 advanced 的优先级设置到最大
		// advanced.setPriority(Thread.MAX_PRIORITY);
		advanced.start();
		
		YieldThread elementary = new YieldThread("低级");
		// elementary.setPriority(Thread.MIN_PRIORITY);
		elementary.start();
	}
}
