package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.util.Date;

/**
 * 测试日期
 *
 * @author hoojo
 * @version 1.0
 * @date Feb 13, 2011 11:05:06 PM
 */
public class DateTest extends BasedTests {

	public static void main(String[] args) {
		Date d1 = new Date();
		//获取当前时间之后的100ms的时间
		Date d2 = new Date(System.currentTimeMillis() + 100);
		out(d2);
		out(d1.compareTo(d2));
		out(d1.before(d2));
	}
}
