package io.github.hooj0.thread.account;

/**
 * 取款对象，非线程安全
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 2, 2010 10:28:01 PM
 * @file Account.java
 * @package com.hoo.thread.account
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class Account {

    private String number;
    private double money;

    public Account(String number, double money) {
        this.number = number;
        this.money = money;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == Account.class) {
            Account a = (Account) o;
            return a.getNumber().equals(this.number);
        }
        return false;
    }
}
