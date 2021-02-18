package io.github.hooj0.thread.account.custom;

/**
 * <b>function:</b>用wait、notifyAll操作线程
 * @author hoojo
 * @createDate Nov 2, 2010 10:28:01 PM
 * @file Account.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class Account {
	private String number;
	private double money;
	private boolean flag = false;
	public String getNumber() {
		return number;
	}
	public double getMoney() {
		return money;
	}
	public Account(String number, double money) {
		this.number = number;
		this.money = money;
	}
	
	public synchronized void draw(double drawMoney) {
		try {
			//如果flag为假，表示账户中还没有人存取，则取钱阻塞（不能取钱）
			if (!flag) {
				wait();
			} else {
				//执行取钱
				System.out.print(Thread.currentThread().getName() + " 取钱：" + drawMoney);
				money -= drawMoney;
				System.out.println(" 账户余额：" + money);
				//将账户是否已存款表示false
				flag = false;
				//唤醒其他线程
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void deposit(double depositMoney) {
		try {
			//如果flag为真，表示账户有人存款，则不能存款，存款阻塞
			if (flag) {
				wait();
			} else {
				System.out.print(Thread.currentThread().getName() + " 存钱：" + depositMoney);
				money += depositMoney;
				System.out.println("余额：" + money);
				//已存款，表示false
				flag = true;
				//唤醒其他线程
				notifyAll();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int hashCode() {
		return this.number.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == Account.class) {
			Account a = (Account) o;
			return a.getNumber().equals(number);
		}
		return false;
	}
}
