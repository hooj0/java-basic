package io.github.hooj0.thread.account.condition;

/**
 * 同步存款
 * @author hoojo
 * @createDate Nov 6, 2010 6:53:30 PM
 * @file DepositThread.java
 * @package com.hoo.thread.account.condition
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DepositThread extends Thread {

	private final ConditionAccount account;
	private final double depositMoney;

	public DepositThread(String name, ConditionAccount account, double depositMoney) {
		super(name);

		this.account = account;
		this.depositMoney = depositMoney;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(depositMoney);
		}
	}
}
