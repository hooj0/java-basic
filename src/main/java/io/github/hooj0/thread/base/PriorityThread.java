package io.github.hooj0.thread.base;

/**
 * 线程优先级
 * @author hoojo
 * @createDate Nov 6, 2010 6:39:40 PM
 * @file PriorityThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class PriorityThread extends Thread {

	public PriorityThread(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + ", " + i + " ,优先级：" + this.getPriority());
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++) {
			if (i == 10) {
				PriorityThread pt = new PriorityThread("低级");
				pt.start();
				System.out.println(pt.getName() + " 创建优先级：" + pt.getPriority());
				pt.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20) {
				PriorityThread pt = new PriorityThread("高级");
				pt.start();
				System.out.println(pt.getName() + " 创建优先级：" + pt.getPriority());
				pt.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
