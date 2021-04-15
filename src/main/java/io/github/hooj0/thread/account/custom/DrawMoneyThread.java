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
@SuppressWarnings("ALL")
public class DrawMoneyThread extends Thread {

	// 模拟账户
	private final Account account;
	private final double drawMoney;

	public DrawMoneyThread(String name, Account account, double drawMoney) {
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.draw(drawMoney);
		}
	}
}
