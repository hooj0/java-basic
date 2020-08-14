package io.github.hooj0.exception;

/**
 * 异常捕获测试
 *
 * @author hoojo
 * @version 1.0
 * @date Mar 3, 2011 10:50:59 PM
 */
public class FAQTryCatchTest {

	public int method() {
		try {
			return 1/0;
		} catch (Exception e) {
			System.out.println("catch");
			return 1;
		} finally {
			System.out.println("finally");
			return 3;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new FAQTryCatchTest().method());
	}
}
