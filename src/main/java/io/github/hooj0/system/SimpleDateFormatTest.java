package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 简单日期格式测试
 *
 * @author hoojo
 * @version 1.0
 * @date Feb 25, 2011 11:43:01 PM
 */
public class SimpleDateFormatTest extends BasedTests {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy年中第D天");
		String str = sdf.format(d);
		out(str);
		String s = "11###二月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		out(sdf2.parse(s));
	}

}
