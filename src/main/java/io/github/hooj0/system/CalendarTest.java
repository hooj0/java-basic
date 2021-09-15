package io.github.hooj0.system;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		//取得年
		System.out.println(c.get(Calendar.YEAR));
		//取得月
		System.out.println(c.get(Calendar.MONTH));
		//取得日
		System.out.println(c.get(Calendar.DATE));
		
		//分别设置年月日、时分秒
		c.set(2011, 2, 13, 23, 20, 55);//2011-02-13 23:20:55
		
		System.out.println(c.getTime());
		//将Calendar的年前推1年
		c.add(Calendar.YEAR, -1);//2010-02-13 23:20:55
		System.out.println(c.getTime());
		
		//将Calendar的年前推8年
		c.roll(Calendar.MONTH, -8);//2010-06-13 23:20:55
		System.out.println(c.getTime());
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2011, 7, 23, 0, 0, 0);
		c1.add(Calendar.MONTH, 6);
		System.out.println(c1.getTime());
		
		Calendar c2 = Calendar.getInstance();
		c2.set(2011, 7, 31, 0, 0, 0);
		//2月没有31号，自动变成29
		c2.add(Calendar.MONTH, 6);
		System.out.println(c2.getTime());
		
		Calendar c3 = Calendar.getInstance();
		c3.set(2011, 7, 23, 0, 0, 0);
		//Month进位，Year不变
		c3.roll(Calendar.MONTH, 6);
		System.out.println(c3.getTime());
		
		Calendar c4 = Calendar.getInstance();
		c4.set(2011, 7, 31, 0, 0, 0);
		//2月没有31，Year不变 所以2月是28号
		c4.roll(Calendar.MONTH, 6);
		System.out.println(c4.getTime());
		
		//Calendar的容错性
		Calendar cal = Calendar.getInstance();
		//月份没有13
		cal.set(Calendar.MONTH, 13);
		System.out.println(cal.getTime());
		//关闭容错性
		//cal.setLenient(false);
		cal.set(Calendar.MONTH, 13);
		System.out.println(cal.getTime());
		
		Calendar call = Calendar.getInstance();
		call.set(2011, 7, 31);//2011-8-31
		call.set(Calendar.MONTH, 8);//理论上应该是10-1，但实际上是9-31（错误不合法的日期）
		//下面输出10-1
		System.out.println(call.getTime());
		
		call.set(Calendar.DATE, 5);
		System.out.println(call.getTime());
	}
}
