package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 数字格式测试
 *
 * @author hoojo
 * @version 1.0
 * @date Feb 25, 2011 10:52:13 PM
 */
public class NumberFormatTest extends BasedTests {

	public static void main(String[] args) {
		double db = 1234000.567;
		Locale[] locales = { Locale.CHINA, Locale.JAPAN, Locale.GERMAN, Locale.US };
		NumberFormat[] nf = new NumberFormat[12];

		for (int i = 0; i < locales.length; i++) {
			nf[i + 3] = NumberFormat.getNumberInstance(locales[i]);
			nf[i + 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
			nf[i + 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
		}

		for (int i = 0; i < locales.length; i++) {
			switch (i) {
				case 0:
					out("-----中国------");
					break;
				case 1:
					out("-----日本-------");
					break;
				case 2:
					out("-----德国------");
					break;
				case 3:
					out("-----美国-------");
					break;
			}

			out("通用价值格式：" + nf[i + 3].format(db));
			out("百分比格式：" + nf[i + 3 + 1].format(db));
			out("货币格式：" + nf[i + 3 + 2].format(db));
		}
	}
}
