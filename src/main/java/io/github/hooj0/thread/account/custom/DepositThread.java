package io.github.hooj0.thread.account.custom;

/**
 * <b>function:</b>存款
 * @author hoojo
 * @createDate Nov 6, 2010 6:51:05 PM
 * @file DepositThread.java
 * @package com.hoo.thread.account.custom
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DepositThread extends Thread {
	private Account acc;
	private double depositMoney;
	public DepositThread(String name, Account acc, double depositMoney) {
		super(name);
		this.acc = acc;
		this.depositMoney = depositMoney;
	}
	
	@Override
	public synchronized void run() {
		for (int i = 0; i < 100; i++) {
			acc.deposit(depositMoney);
		}
	}
}
