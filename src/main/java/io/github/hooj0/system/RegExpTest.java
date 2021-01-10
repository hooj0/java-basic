package io.github.hooj0.system;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Feb 15, 2011 10:33:53 PM
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "hello , java!";
		//贪婪模式的正则表达式
		System.out.println(str.replaceFirst("\\w*", "~"));;
		//勉强模式的正则表达式
		System.out.println(str.replaceFirst("\\w*?", "~"));
		
		//将一个字符串编译成Pattern对象
		Pattern p = Pattern.compile("a*b");
		//使用Pattern对象创建Matcher对象
		Matcher m = p.matcher("aaaaaab");
		boolean b = m.matches();//返回true
		System.out.println(b);
		
		//和上面效果一样
		b = Pattern.matches("a*b", "aaaaab");
		System.out.println(b);
		
		m = Pattern.compile("\\w+").matcher("Java is very easy!");
		while (m.find()) {
			System.out.println(m.group());
		}
		int i = 0;
		while (m.find(i)) {
			System.out.print(m.group() + "\t");
			i++;
		}
		
		str = "Java is very easy";
		System.out.println("目标是：" + str);
		m = Pattern.compile("\\w+").matcher(str);
		while (m.find()) {
			System.out.println(m.group() + "子串的起始位置：" + m.start() + ", 其结束位置： " + m.end());
		}
		
		String[] mails = {
				"aa@163.com",
				"sdba@gmail.com",
				"ykoo@abc.cn",
				"wow@dsd.org"
		};
		
		String mailReg = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		p = Pattern.compile(mailReg);
		Matcher matcher = null;
		for (String mail : mails) {
			if (matcher == null) {
				matcher = p.matcher(mail);
			} else {
				matcher.reset(mail);
			}
			if (matcher.matches()) {
				System.out.println(mail + "有效邮箱！");
			} else {
				System.out.println(mail + "无效邮箱！");
			}
		}
		
		String[] strs = {
				"Java has regular expression in 1.4",
				"regular expressions now expression in Java",
				"Java represses oracular expression"
		};
		p = Pattern.compile("re\\w");
		Matcher matcher2 = null;
		for (i = 0; i < strs.length; i++) {
			if (matcher2 == null) {
				matcher2 = p.matcher(strs[i]);
			} else {
				matcher2.reset(strs[i]);
			}
			System.out.println(matcher2.replaceAll("哈哈\2"));
		}
		
		for (String s : strs) {
			System.out.println(s.replaceFirst("re\\w*", "哈哈\1"));
			System.out.println(Arrays.toString(s.split(" ")));
		}
	}
}
