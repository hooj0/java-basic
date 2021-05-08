package io.github.hooj0.thread.account.condition;

/**
 * 同步取款线程
 * @author hoojo
 * @createDate Nov 6, 2010 6:53:53 PM
 * @file DrawMoenyThread.java
 * @package com.hoo.thread.account.condition
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class DrawMoneyThread extends Thread {

	//模拟账户
	private ConditionAccount account;
	private double drawMoney;

	public DrawMoneyThread(String name, ConditionAccount account, double drawMoney) {
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
