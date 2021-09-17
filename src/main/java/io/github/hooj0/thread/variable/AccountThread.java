package io.github.hooj0.thread.variable;

public class AccountThread extends Thread {
	//定义一个Account属性
	private Account acc;
	public AccountThread(Account acc, String name) {
		this.setName(name);
		this.acc = acc;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				acc.setName(getName());
			}
			System.out.println(acc.getName() + " 账户的i值：" + i);
		}
	}
}
