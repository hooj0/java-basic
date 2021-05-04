package io.github.hooj0.thread.account;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全的，同步锁
 * @author hoojo
 * @createDate Nov 2, 2010 10:28:44 PM
 * @file SafetyAccount.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class LockAccount {
	//创建锁对象
	private final ReentrantLock rtLock = new ReentrantLock();
	private String number;
	private double money;
	public String getNumber() {
		return number;
	}
	//只能通过线程安全的方法修改账户信息，取消setter方法
	public double getMoney() {
		return money;
	}
	
	public LockAccount(String number, double money) {
		this.number = number;
		this.money = money;
	}
	
	/**
	 * 线程安全的，用锁进行资源锁定
	 * 支持多线程并发操作
	 * @author hoojo
	 * @createDate Nov 2, 2010 10:32:12 PM
	 * @param drawMoney
	 */
	public void drawMoneyMethod(double drawMoney) {
		//添加同步锁
		rtLock.lock();
		try {
			if (this.money >= drawMoney) {
				System.out.println(Thread.currentThread().getName() + "在账户：" + this.getNumber() + "取款" + drawMoney);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.money = this.getMoney() - drawMoney;
				System.out.println("余额:" + this.getMoney());
			} else {
				System.out.println(Thread.currentThread().getName() + " 取款无效，余额不足！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//在fianlly中释放锁
			rtLock.unlock();
		}
	}
	
	@Override
	public int hashCode() {
		return this.number.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == LockAccount.class) {
			LockAccount a = (LockAccount) o;
			return a.getNumber().equals(number);
		}
		return false;
	}
}
