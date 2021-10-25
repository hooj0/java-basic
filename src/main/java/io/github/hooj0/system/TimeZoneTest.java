package io.github.hooj0.system;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeZoneTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Feb 14, 2011 10:23:35 PM
	 * @param args
	 */
	public static void main(String[] args) {
		//获取所有时区的id
		String[] ids = TimeZone.getAvailableIDs();
		System.out.println(Arrays.toString(ids));
		
		TimeZone tz = TimeZone.getDefault();
		//获取系统默认时区
		System.out.println(tz.getID());
		//获取系统默认时区的名称
		System.out.println(tz.getDisplayName());
		//获取指定id的时区的名称
		System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());
	}
}
