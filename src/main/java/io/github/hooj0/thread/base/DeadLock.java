package io.github.hooj0.thread.base;

/**
 * 线程死锁示例
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 6, 2010 3:34:55 PM
 * @file DeadLock.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class DeadLock extends Thread {

    Foo foo = new Foo();
    Bar bar = new Bar();

    public void init() {
        Thread.currentThread().setName("主线程");
        // 调用foo对象的foo方法
	    this.foo.foo(this.bar);
        System.out.println("进入了主线程……");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        // 调用了bar对象的bar方法
	    this.bar.bar(this.foo);
        System.out.println("进入副线程……");
    }

    public static void main(String[] args) {
        DeadLock lock = new DeadLock();
        lock.start();
        lock.init();
        /**
         * 程序一直僵持，没有异常、错误，也没有提示
         * 原因：上面程序中Foo对象和Bar对象的方法都是同步的方法，也就是Foo和Bar对象方法都是同步锁
         * 程序运行，线程调用了run方法，而main方法主线程调用了init方法
         * run中的b调用bar方法，而init中的Foo对象调用foo方法。
         * 从控制台中可以看出，init方法先执行，调用了Foo对象的foo方法，进入foo方法前，该线程对Foo对象
         * 加锁，当程序运行到sleep，主线程暂停200毫秒，cup切换到副线程，让Bar对象执行bar方法
         * 所以在控制台看到副线程运行Bar实例的bar方法，进入bar方法前该线程需要对Bar对象加锁
         * 然后bar对象休眠200毫秒，接下来是主线程苏醒，继续向下运行，调用Bar对象barMethod方法
         * 执行前必须对Bar对象加锁，但是副线程对Bar对象保存锁定状态，这时主线程进入阻塞状态
         * 其后副线程醒来，继续运行，调用foo对象的fooMethod方法，执行fooMethod方法前必须对foo
         * 对象加锁，但是foo对象被主线程锁定。
         * 主线程保持对Foo的锁定，等待对Bar对象加锁，而副线程却对Bar对象保持锁定，等待对Foo加锁
         * 2条线程相互等待对方先释放锁，进入死锁状态
         * 由于Thread类的suspend也很容易导致死锁，所以Java不推荐使用此方法暂停线程
         */
    }
}

class Foo {
    public synchronized void foo(Bar b) {
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 进入了Foo实例的foo方法");
        try {
            //Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 企图调用Bar实例barMethod方法");
        b.barMethod();
    }

    public synchronized void fooMethod() {
        System.out.println("进入了Foo实例的fooMethod方法");
    }
}

class Bar {
    public synchronized void bar(Foo f) {
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 进入了Bar实例的bar方法");
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 企图调用Foo实例fooMethod方法");
        f.fooMethod();
    }

    public synchronized void barMethod() {
        System.out.println("进入了Bar实例的barMethod方法");
    }
}