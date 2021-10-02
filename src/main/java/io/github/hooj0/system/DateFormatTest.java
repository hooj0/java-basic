package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式测试
 *
 * @author hoojo
 * @version 1.0
 * @date Feb 25, 2011 11:18:56 PM
 */
public class DateFormatTest extends BasedTests {

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
					out("------中国-------");
					break;
				case 1:
					out("------美国-------");
					break;
				default:
					continue;
			}

			out("short格式日期：" + df[i * 8].format(d));
			out("medium格式日期：" + df[i * 8 + 1].format(d));
			out("long格式日期：" + df[i * 8 + 2].format(d));
			out("full格式日期：" + df[i * 8 + 3].format(d));
			out("short格式日期：" + df[i * 8 + 4].format(d));
			out("medium格式日期：" + df[i * 8 + 5].format(d));
			out("long格式日期：" + df[i * 8 + 6].format(d));
			out("full格式日期：" + df[i * 8 + 7].format(d));
		}
	}
}
