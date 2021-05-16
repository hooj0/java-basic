package io.github.hooj0.thread.group;

import io.github.hooj0.BasedTests;

/**
 * 应用程序
 *
 * @author hoojo
 * @version 1.0
 * @date Nov 6, 2010 6:57:22 PM
 */
public class App extends BasedTests {

    public static void main(String[] args) {
        //获得主线程所在的线程组，这是所有线程默认的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        out("主线程的名称：" + mainGroup.getName());
        out("是否后台线程组：" + mainGroup.isDaemon());

        new CustomGroupThread("主线程组的线程").start();
        ThreadGroup tg = new ThreadGroup("新线程组-后台线程组");
        tg.setDaemon(true);
        out("新线程组-后台线程组 是否是后台线程" + tg.isDaemon());

        new CustomGroupThread(tg, "新线程组-后台线程组 的线程A").start();
        new CustomGroupThread(tg, "新线程组-后台线程组 的线程B").start();
    }
}
/*
 * uncaughtException(Thread t, Throwable e)
 * 该方法可以处理该线程组内的线程所抛出的未处理的异常
 */