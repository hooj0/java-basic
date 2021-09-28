package io.github.hooj0.thread.base;

/**
 * <b>function:</b> 用接口实现线程，重写run方法
 * @author hoojo
 * @createDate Oct 31, 2010 1:46:02 PM
 * @file BaseRunableThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class BaseRunableThread implements Runnable {
	
	private int i = 0;
	public void run() {
		for (; i < 100; i++) {
			/*
			 * 实现Runnable接口的方式，需要用Thread.currentThread()来获得当前线程
			 * 而继承Thread只需用this就可以获得当前线程
			 */
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 31, 2010 1:23:11 PM
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			//调用Thread的currentThread方法获得当前线程
			System.out.println(Thread.currentThread().getName() + "%%" + i);
			if (i == 20) {
				//不共享变量
				//new Thread(new BaseRunableThread(), "无变量共享线程1").start();
				//new Thread(new BaseRunableThread(), "无变量共享线程2").start();
				//共享变量，同一个目标对象，运行的run方法体是同一个Thread的方法体
				//Runnable t = new BaseRunableThread();
				BaseRunableThread t = new BaseRunableThread();
				new Thread(t, "变量共享线程1").start();
				new Thread(t, "变量共享线程2").start();
			}
		}
	}
}
/**
 * 定义一个类实现Runnable接口，并实现run方法
 * 创建一个Thread将实现Runnable的类作为参数传递给Thread的构造方法即可；
 * 
 * Runnable对象仅仅作为Thread的target，Runnable实现类里包含run方法仅作为
 * 线程的执行体。而实际线程对象还是Thread实例，只是该Thread线程负责执行其target
 * 的run方法。出于这种考虑，Thread类是否可以把任意对象的任意方法作为线程的执行体？
 * Java中是不可以的，Thread必须使用Runnable对象的run方法作为线程的执行体，
 * 但C#却可以做到。
 */
/**
 * 用接口实现线程最大的区别是：
 * 接口创建线程可以共享变量
 * 而用Thread创建线程，每次都需要new一个对象，则不能共享变量
 */