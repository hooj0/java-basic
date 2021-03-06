package io.github.hooj0.thread.base;

/**
 * join线程示例
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 6, 2010 6:38:15 PM
 * @file JoinThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class JoinThread extends Thread {

    public JoinThread(String name) {
        //super(name);
        this.setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JoinThread("线程").start();

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread joinThread = new JoinThread("join线程");
                joinThread.start();
                /*
                 * main线程调用了jt join线程，必须等待jt线程运行完了后才能运行
                 */
                joinThread.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
