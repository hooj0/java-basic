package io.github.hooj0.thread.account.custom;

/**
 * 取款线程
 * @author hoojo
 * @createDate Nov 6, 2010 6:51:27 PM
 * @file DrawMoenyThread.java
 * @package com.hoo.thread.account.custom
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DrawMoenyThread extends Thread {
	//模拟账户
	private Account acc;
	private double drawMoney;
	public DrawMoenyThread(String name, Account acc, double drawMoney) {
		super(name);
		this.acc = acc;
		this.drawMoney = drawMoney;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			acc.draw(drawMoney);
		}
	}
}
