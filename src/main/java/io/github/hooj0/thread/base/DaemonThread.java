package io.github.hooj0.thread.base;

/**
 * 后台线程示例
 * @author hoojo
 * @createDate Oct 31, 2010 4:36:46 PM
 * @file DaemonThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DaemonThread extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		//设置为后台进程
		dt.setDaemon(true);
		dt.start();
		System.out.println(dt.isDaemon());//是否后台线程
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		/*
		 * 当main线程循环10次后就执行完成，这时前台线程也就死亡。JVM会退出运行，那样后台线程也就结束
		 * 所以后台线程无法运行到999就结束了
		 * 因为后台线程为前台线程服务，只要前台线程死亡后台线程也会立即死亡
		 */
	}
}
/**
 * 注意：前台线程执行完成死亡后，JVM会通知后台线程，后台线程就会死亡。但它得到通知到后台线程作成
 * 响应，需要一段时间，而且要将某个线程设置为后台线程，必需要在该线程启动前设置，也就是说设置setDaemon
 * 必需在start方法前面调用。否则会出现java.lang.IllegalThreadStateException异常
 */
