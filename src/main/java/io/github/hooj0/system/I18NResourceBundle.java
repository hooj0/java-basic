package io.github.hooj0.system;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18NResourceBundle {

	/**
	 * 
	 * @author hoojo
	 * @createDate Feb 21, 2011 11:17:49 PM
	 * @param args
	 */
	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			System.out.println(locales[i].getDisplayCountry() + "=" + locales[i].getCountry() + " "
					+ locales[i].getDisplayLanguage() + "=" + locales[i].getLanguage());
		}
		
		System.out.println();
		
		Locale locale = Locale.US;//Locale.getDefault();
		
		ResourceBundle bundle = ResourceBundle.getBundle("mess", locale);
		System.out.println(bundle.getString("hello"));
		
		//MessageFormat
		System.out.println(MessageFormat.format("haha", "zhangsan", new Date()));
	}
}
