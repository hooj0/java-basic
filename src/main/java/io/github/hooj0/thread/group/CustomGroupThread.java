package io.github.hooj0.thread.group;

/**
 * 线程组简单示例
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 6, 2010 6:31:17 PM
 * @file TestGroupThread.java
 * @package com.hoo.thread.group
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class GroupThread extends Thread {

    public GroupThread(String name) {
        super(name);
    }

    //指定线程组和线程名称
    public GroupThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName() + " 线程的i 是" + i);
        }
    }
}
