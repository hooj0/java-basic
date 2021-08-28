package io.github.hooj0.system;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Feb 25, 2011 10:52:13 PM
	 * @param args
	 */
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
					System.out.println("-----中国------");
					break;
				case 1:
					System.out.println("-----日本-------");
					break;
				case 2:
					System.out.println("-----德国------");
					break;
				case 3:
					System.out.println("-----美国-------");
					break;
			}
			System.out.println("通用价值格式：" + nf[i + 3].format(db));
			System.out.println("百分比格式：" + nf[i + 3 + 1].format(db));
			System.out.println("货币格式：" + nf[i + 3 + 2].format(db));
		}
	}
}
