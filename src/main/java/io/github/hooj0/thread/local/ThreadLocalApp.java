package io.github.hooj0.thread.variable;

/**
 * 线程本地测试
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 7, 2010 5:32:14 PM
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class ThreadLocalApp {

    public static void main(String[] args) {

        //启动2条线程，2条线程共享一个Account
        Account acc = new Account("初始化值");

        /**
         * 虽然2条线程共享同一个账户，即只有一个账户名
         * 当由于账户名是ThreadLocal类型的，所以以两条线程将
         * 导致有同一个Account，但有2个账户名的副本，每条线程都完全拥有
         * 各自的账户名副本，所以从i=6之后，将看到两条线程访问同一个账户
         * 时看到不同的用户名
         */
        new AccountThread(acc, "A").start();
        new AccountThread(acc, "B").start();
    }
}
