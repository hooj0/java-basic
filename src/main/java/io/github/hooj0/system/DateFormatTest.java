package io.github.hooj0.system;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Feb 25, 2011 11:18:56 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Date d = new Date();
		Locale[] locales = { Locale.CHINA, Locale.UK };
		DateFormat[] df = new DateFormat[16];
		for (int i = 0; i < locales.length; i++) {
			df[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
			df[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
			df[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
			df[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
			df[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
			df[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
			df[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
			df[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
		}
		for (int i = 0; i < locales.length; i++) {
			switch (i) {
				case 0:
					System.out.println("------中国-------");
					break;
				case 1:
					System.out.println("------美国-------");
					break;
			}
			System.out.println("short格式日期：" + df[i * 8].format(d));
			System.out.println("medium格式日期：" + df[i * 8 + 1].format(d));
			System.out.println("long格式日期：" + df[i * 8 + 2].format(d));
			System.out.println("full格式日期：" + df[i * 8 + 3].format(d));
			System.out.println("short格式日期：" + df[i * 8 + 4].format(d));
			System.out.println("medium格式日期：" + df[i * 8 + 5].format(d));
			System.out.println("long格式日期：" + df[i * 8 + 6].format(d));
			System.out.println("full格式日期：" + df[i * 8 + 7].format(d));
		}
	}
}
