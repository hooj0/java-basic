package io.github.hooj0.thread.account;

/**
 * <b>function:</b>取款操作线程类，操作有锁对象
 * @author hoojo
 * @createDate Nov 2, 2010 10:28:25 PM
 * @file OperateAccountThread.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class OperateLockAccountThread extends Thread {
	private LockAccount acc;
	private double drawMoney;
	public OperateLockAccountThread(String name, LockAccount acc, double drawMoney) {
		this.setName(name);
		this.acc = acc;
		this.drawMoney = drawMoney;
	}
	
	public void run() {
		acc.drawMoneyMethod(drawMoney);
	}
}
