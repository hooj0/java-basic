package io.github.hooj0.system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Feb 25, 2011 11:43:01 PM
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy年中第D天");
		String str = sdf.format(d);
		System.out.println(str);
		String s = "11###二月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		System.out.println(sdf2.parse(s));
	}

}
