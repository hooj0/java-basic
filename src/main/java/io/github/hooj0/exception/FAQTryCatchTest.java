package io.github.hooj0.exception;

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
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Mar 3, 2011 10:50:59 PM
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new FAQTryCatchTest().method());
	}

}
