package io.github.hooj0.thread.group;

import java.lang.Thread.UncaughtExceptionHandler;

public class TestExceptionHandler implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + " 发生异常：" + e + "\n" + e.getMessage());
	}
	
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new TestExceptionHandler());
		@SuppressWarnings("unused")
		int a = 5 / 0;
	}
}
