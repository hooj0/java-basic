package io.github.hooj0.thread.account.custom;

/**
 * 取款，存款示例
 * @author hoojo
 * @createDate Nov 6, 2010 6:51:42 PM
 * @file Test.java
 * @package com.hoo.thread.account.custom
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class App {

	public static void main(String[] args) {
		Account account = new Account("11232132", 0);
		
		new DrawMoneyThread("取款A", account, 800).start();
		new DepositThread("存款B", account, 800).start();
		new DepositThread("存款C", account, 800).start();
		new DepositThread("存款D", account, 800).start();
		//new DrawMoneyThread("取款E", account, 800).start();
		
		/**
		 * 300次存款，100次取款导致线程阻塞
		 * 上面是线程阻塞，并不是死锁。
		 * 是取钱线程执行完毕，而存钱的线程还在等待取款的线程取款后才能存钱。
		 * 并不是等待是否同步监视器，不要把死锁和程序阻塞等同起来
		 */
	}
}
