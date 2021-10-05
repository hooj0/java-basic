package io.github.hooj0.thread.group;

public class Test {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Nov 6, 2010 6:57:22 PM
	 * @param args
	 */
	public static void main(String[] args) {
		//获得主线程所在的线程组，这是所有线程默认的线程组
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("主线程的名称：" + mainGroup.getName());
		System.out.println("是否后台线程组：" + mainGroup.isDaemon());
		new TestGroupThread("主线程组的线程").start();
		ThreadGroup tg = new ThreadGroup("新线程组-后台线程组");
		tg.setDaemon(true);
		System.out.println("新线程组-后台线程组 是否是后台线程" + tg.isDaemon());
		new TestGroupThread(tg, "新线程组-后台线程组 的线程A").start();
		new TestGroupThread(tg, "新线程组-后台线程组 的线程B").start();
	}
}
/*
 * uncaughtException(Thread t, Throwable e)
 * 该方法可以处理该线程组内的线程所抛出的未处理的异常
 */