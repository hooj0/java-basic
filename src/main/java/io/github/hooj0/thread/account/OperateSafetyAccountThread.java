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
public class OperateSafetyAccountThread extends Thread {

    private final SafetyAccount account;
    private final double drawMoney;

    public OperateSafetyAccountThread(String name, SafetyAccount account, double drawMoney) {
        this.setName(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        /*
         * 线程安全方法
         */
	    this.account.drawMoneyMethod(this.drawMoney);
    }
}
