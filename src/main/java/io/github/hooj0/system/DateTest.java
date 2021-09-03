package io.github.hooj0.system;

import java.util.Date;

public class DateTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Feb 13, 2011 11:05:06 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Date d1 = new Date();
		//获取当前时间之后的100ms的时间
		Date d2 = new Date(System.currentTimeMillis() + 100);
		System.out.println(d2);
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.before(d2));
	}
}
