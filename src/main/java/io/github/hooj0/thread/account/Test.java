package io.github.hooj0.thread.account;

public class Test {

	/**
	 *
	 * @author hoojo
	 * @createDate Oct 31, 2010 6:28:16 PM
	 * @param args
	 */
	public static void main(String[] args) {
		//Account acc = new Account("6554454548521369", 1000D);
		//模拟取钱
		//new OperateAccountThread("A", acc, 800).start();
		//new OperateAccountThread("B", acc, 900).start();
		
		//线程安全方法，一样的效果
		//SafetyAccount sa = new SafetyAccount("6554454548521369", 1000D);
		//new OperateSafetyAccountThread("A", sa, 800).start();
		//new OperateSafetyAccountThread("B", sa, 700).start();
		
		//带锁资源
		LockAccount la = new LockAccount("6554454548521369", 1000D);
		new OperateLockAccountThread("甲", la, 800).start();
		new OperateLockAccountThread("乙", la, 800).start();
	}
}
