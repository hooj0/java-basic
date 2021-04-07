package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * i18 n 国际化测试
 *
 * @author hoojo
 * @version 1.0
 * @date Feb 21, 2011 11:17:49 PM
 */
public class I18NResourceBundle extends BasedTests {

	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			out(locales[i].getDisplayCountry() + "=" + locales[i].getCountry() + " "
					+ locales[i].getDisplayLanguage() + "=" + locales[i].getLanguage());
		}
		
		out();
		
		Locale locale = Locale.US; // Locale.getDefault();
		
		ResourceBundle bundle = ResourceBundle.getBundle("mess", locale);
		out(bundle.getString("hello"));
		
		//MessageFormat
		out(MessageFormat.format("haha", "zhangsan", new Date()));
	}
}
