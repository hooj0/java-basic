package io.github.hooj0.thread.account;

/**
 * 线程安全的
 * @author hoojo
 * @createDate Nov 2, 2010 10:28:44 PM
 * @file SafetyAccount.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class SafetyAccount {

	private String number;
	private double money;
	
	public String getNumber() {
		return number;
	}
	/**
	 * 取消setter方法，不容许访问；线程不安全
	 */
	public double getMoney() {
		return money;
	}
	
	public SafetyAccount(String number, double money) {
		this.number = number;
		this.money = money;
	}
	
	/**
	 * 同步关键字synchronized修饰，线程安全的
	 * 支持多线程并发操作
	 * @author hoojo
	 * @createDate Nov 2, 2010 10:32:12 PM
	 * @param drawMoney
	 */
	public synchronized void drawMoneyMethod(double drawMoney) {
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
	}
	
	@Override
	public int hashCode() {
		return this.number.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == SafetyAccount.class) {
			SafetyAccount a = (SafetyAccount) o;
			return a.getNumber().equals(number);
		}
		return false;
	}
}
