package io.github.hooj0.thread.group;

/**
 * 线程组简单示例
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 14:59:15
 */
public class CustomGroupThread extends Thread {

    public CustomGroupThread(String name) {
        super(name);
    }

    // 指定线程组和线程名称
    public CustomGroupThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName() + " 线程的i 是" + i);
        }
    }
}
