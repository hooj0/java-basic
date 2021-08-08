package io.github.hooj0.thread.pool;

/**
 * 实现Runnable接口的线程
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 7, 2010 5:14:55 PM
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class RunnableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "的i值是：" + i);
        }
    }
}
