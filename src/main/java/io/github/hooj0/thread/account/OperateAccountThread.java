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
public class OperateAccountThread extends Thread {
	private Account acc;
	private double drawMoney;
	public OperateAccountThread(String name, Account acc, double drawMoney) {
		this.setName(name);
		this.acc = acc;
		this.drawMoney = drawMoney;
	}
	
	public void run() {
		/**
		 * 方法一：同步代码块
		 * 用同步代码块锁定账户，然后线程进入同步方法前都需要锁定账户
		 * 必需先获得账户，对其锁定，其他线程就无法获得账户，无法修改
		 * 锁定->修改->释放锁
		 * 每次只能一个线程操作账户
		 */
		synchronized (acc) {
			if (acc.getMoney() >= drawMoney) {
				System.out.println(getName() + "在账户：" + this.acc.getNumber() + "取款" + drawMoney);
				/*try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				acc.setMoney(acc.getMoney() - drawMoney);
				System.out.println("余额:" + acc.getMoney());
			} else {
				System.out.println(getName() + " 取款无效，余额不足！");
			}
		}
	}
}
