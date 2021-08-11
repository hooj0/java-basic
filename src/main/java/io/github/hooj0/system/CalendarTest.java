package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.util.Calendar;

/**
 * 日历测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 18:03:08
 */
@SuppressWarnings("ALL")
public class CalendarTest extends BasedTests {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		//取得年
		out(c.get(Calendar.YEAR)); // 2022
		//取得月
		out(c.get(Calendar.MONTH)); // 0
		//取得日
		out(c.get(Calendar.DATE)); // 26
		
		//分别设置年月日、时分秒
		c.set(2011, 2, 13, 23, 20, 55);//2011-02-13 23:20:55
		
		out(c.getTime()); // Sun Mar 13 23:20:55 CST 2011

		//将Calendar的年前推1年
		c.add(Calendar.YEAR, -1); //2010-02-13 23:20:55
		out(c.getTime()); // Sat Mar 13 23:20:55 CST 2010
		
		//将Calendar的年前推8年
		c.roll(Calendar.MONTH, -8);//2010-06-13 23:20:55
		out(c.getTime()); // Tue Jul 13 23:20:55 CST 2010
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2011, 7, 23, 0, 0, 0);
		c1.add(Calendar.MONTH, 6);
		out(c1.getTime());
		
		Calendar c2 = Calendar.getInstance();
		c2.set(2011, 7, 31, 0, 0, 0);
		//2月没有31号，自动变成29
		c2.add(Calendar.MONTH, 6);
		out(c2.getTime());
		
		Calendar c3 = Calendar.getInstance();
		c3.set(2011, 7, 23, 0, 0, 0);
		//Month进位，Year不变
		c3.roll(Calendar.MONTH, 6);
		out(c3.getTime());
		
		Calendar c4 = Calendar.getInstance();
		c4.set(2011, 7, 31, 0, 0, 0);
		//2月没有31，Year不变 所以2月是28号
		c4.roll(Calendar.MONTH, 6);
		out(c4.getTime());
		
		//Calendar的容错性
		Calendar cal = Calendar.getInstance();
		//月份没有13
		cal.set(Calendar.MONTH, 13);
		out(cal.getTime());

		//关闭容错性
		//cal.setLenient(false);
		cal.set(Calendar.MONTH, 13);
		out(cal.getTime());
		
		Calendar call = Calendar.getInstance();
		call.set(2011, 7, 31);//2011-8-31
		call.set(Calendar.MONTH, 8);//理论上应该是10-1，但实际上是9-31（错误不合法的日期）
		//下面输出10-1
		out(call.getTime());
		
		call.set(Calendar.DATE, 5);
		out(call.getTime());
	}
}
