package io.github.hooj0.thread.base;

/**
 * 线程基本、简单操作
 * @author hoojo
 * @createDate Oct 31, 2010 1:12:47 PM
 * @file BaseThread.java
 * @package com.hoo.thread.base
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class BaseThread extends Thread {

	private int i = 0;
	/*
	 * 线程执行体：重写父类Thread的run方法
	 */
	@Override
	public void run() {
		for (; i < 100; i++) {
			/**
			 * 当线程类创建时，可以直接调用getName方法返回当前线程名称
			 * 如果想获得当前线程，直接使用this
			 */
			System.out.println(this.getName() + "##" + i);
		}
	}
	/**
	 *
	 * @author hoojo
	 * @createDate Oct 31, 2010 1:12:11 PM
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 100; i++) {
			//调用Thread的currentThread方法获得当前线程
			System.out.println(Thread.currentThread().getName() + "%%" + i);
			if (i == 20) {
				BaseThread bt = new BaseThread();
				bt.start();
				//bt.sleep(1);
				/*
				 * 重复启动会出现java.lang.IllegalThreadStateException异常
				 */
				//bt.start();
				new BaseThread().start();
				/*
				 * 直接运行run方法不再是线程了就是一个普通的Java对象
				 */
				/*new BaseThread().run();
				new BaseThread().run();*/
			}
		}
	}
}
/**
 * 继承Thread类，来创建线程
 *  A、	继承Thread类或实现Runable接口，重写或实现run方法，run方法代表线程要完成的任务
 *	B、	创建Thread子类或是Runable的实现类，即创建的线程对象
 *	C、	用线程对象的start方法启动线程
 */

/*
 * 此类显示的创建了2个线程，但当前程序至少有三个线程；
 * 因为Java程序在运行后，至少创建一个主线程，主线程的执行体不是run方法体
 * 而是main方法，main方法代表主线程。
 * 注意：在多线程编程时切忌不要忘记了Java程序的入口方法main才是主线程，
 * main方法的方法体就是主线程的执行体。
 *
 * 使用Thread类方法来创建线程类，多线程之间无法共享线程类的实例变量
 * 
 * Thread.currentThread()总是返回当前执行的线程
 * getName返回的是现场的名称，当然你也可以通过setName()来制定线程名称；
 * 
 * 如果希望调用子线程的start方法后，子线程会被立即运行，程序可以使用Thread.sleep(1)
 * 休眠一秒，这样另一条线程就会被执行。
 */
