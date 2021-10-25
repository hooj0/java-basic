package io.github.hooj0.thread.account;

import org.junit.Test;

/**
 * 账户测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 17:29:57
 */
public class AccountTest {

	/**
	 * 模拟取钱 账户
	 *
	 * @author hoojo
	 * @date 2022/01/26 17:34:35
	 */
	@Test
	public void account() {
		Account account = new Account("6554454548521369", 1000D);
		new OperateAccountThread("A", account, 800).start();
		new OperateAccountThread("B", account, 900).start();
	}

	/**
	 * 安全账户: 线程安全方法，一样的效果
	 *
	 * @author hoojo
	 * @date 2022/01/26 17:34:09
	 */
	@Test
	public void safetyAccount() {
		SafetyAccount safetyAccount = new SafetyAccount("6554454548521369", 1000D);
		new OperateSafetyAccountThread("A", safetyAccount, 800).start();
		new OperateSafetyAccountThread("B", safetyAccount, 700).start();
	}

	/**
	 * 带锁资源帐户
	 *
	 * @author hoojo
	 * @date 2022/01/26 17:33:55
	 */
	@Test
	public void lockAccount() {
		LockAccount lockAccount = new LockAccount("6554454548521369", 1000D);
		new OperateLockAccountThread("甲", lockAccount, 800).start();
		new OperateLockAccountThread("乙", lockAccount, 800).start();
	}
}
