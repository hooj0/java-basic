package io.github.hooj0.thread.account;

/**
 * 取款操作线程类
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 2, 2010 10:28:25 PM
 * @file OperateAccountThread.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
@SuppressWarnings("ALL")
public class OperateAccountThread extends Thread {

    private final Account account;
    private final double drawMoney;

    public OperateAccountThread(String name, Account account, double drawMoney) {
        this.setName(name);

        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        /**
         * 方法一：同步代码块
         * 用同步代码块锁定账户，然后线程进入同步方法前都需要锁定账户
         * 必需先获得账户，对其锁定，其他线程就无法获得账户，无法修改
         * 锁定->修改->释放锁
         * 每次只能一个线程操作账户
         */
        synchronized (this.account) {
            if (this.account.getMoney() >= this.drawMoney) {
                System.out.println(this.getName() + "在账户：" + this.account.getNumber() + "取款" + this.drawMoney);
				/*try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
	            this.account.setMoney(this.account.getMoney() - this.drawMoney);
                System.out.println("余额:" + this.account.getMoney());
            } else {
                System.out.println(this.getName() + " 取款无效，余额不足！");
            }
        }
    }
}
