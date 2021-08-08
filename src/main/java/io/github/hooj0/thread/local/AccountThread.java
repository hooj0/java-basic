package io.github.hooj0.thread.local;

/**
 * 账户线程
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 14:42:39
 */
public class AccountThread extends Thread {

    /** 定义一个Account属性 */
    private final Account acc;

    public AccountThread(Account acc, String name) {
        this.setName(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
	            this.acc.setName(this.getName());
            }
            System.out.println(this.acc.getName() + " 账户的i值：" + i);
        }
    }
}
