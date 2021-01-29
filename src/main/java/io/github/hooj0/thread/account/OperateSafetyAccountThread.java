package io.github.hooj0.thread.account;

/**
 * 取款操作线程类
 * @author hoojo
 * @createDate Nov 2, 2010 10:28:25 PM
 * @file OperateAccountThread.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class OperateSafetyAccountThread extends Thread {
	private SafetyAccount acc;
	private double drawMoney;
	public OperateSafetyAccountThread(String name, SafetyAccount acc, double drawMoney) {
		this.setName(name);
		this.acc = acc;
		this.drawMoney = drawMoney;
	}
	
	public void run() {
		/*
		 * 线程安全方法
		 */
		acc.drawMoneyMethod(drawMoney);
	}
}
