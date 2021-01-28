package io.github.hooj0.thread.base;

/**
 * <b>function:</b>起点死亡线程会引发java.lang.IllegalThreadStateException异常
 * @author hoojo
 * @createDate Nov 6, 2010 6:40:46 PM
 * @file StartDeadThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class StartDeadThread extends Thread {
	private int i = 0;
	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 31, 2010 3:48:25 PM
	 * @param args
	 */
	public static void main(String[] args) {
		StartDeadThread sdt = new StartDeadThread();
		for (int i = 0; i < 300; i++) {
			System.out.println(Thread.currentThread().getName() + "=" + i);
			if (i < 20) {
				//新建
				//System.out.println(sdt.isAlive());
			}
			if (i == 20) {
				sdt.start();
				//true未死亡，false表示死亡或新建
				System.out.println(sdt.isAlive());
			}
			//线程运行到99就运行完run方法，此时线程死亡，无法重新启动
			if (i > 20 && !sdt.isAlive()) {
				//重复启动该线程
				sdt.start();
			}
		}
	}
}
/**
 * isAlive方法可以测试当前线程是否死亡，当线程处于就绪、运行、阻塞状态，该方法返回true，
 * 如果线程处于新建或死亡状态就会返回false。
 * TODO: 不要试图对死亡的线程调用start方法，来启动它。死亡线程不可能再次运行。
 * 只能对新建状态的线程调用start方法来启动它
 */
