package io.github.hooj0.reflection.method;

import io.github.hooj0.BasedTests;

import java.lang.reflect.Method;

/**
 * 调用测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 5, 2010 4:13:43 PM
 */
public class InvokeTest extends BasedTests {
	
	public int add(int first, int last) {
		return first + last;
	}
	
	public String say(String name) {
		return name + " say: hello world!";
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> clazz = InvokeTest.class;
		Object test = clazz.newInstance();
		//Object test = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
		Method add = clazz.getMethod("add", new Class[]{int.class, int.class});
		Object addVal = add.invoke(test, new Object[]{new Integer(1), new Integer(2)});
		out((Integer)addVal);
		
		Method say = clazz.getMethod("say", new Class[]{String.class});
		Object sayStr = say.invoke(test, new Object[]{"tom"});
		out((String)sayStr);
	}
}
