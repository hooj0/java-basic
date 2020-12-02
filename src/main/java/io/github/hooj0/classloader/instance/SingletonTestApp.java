package io.github.hooj0.classloader.instance;

/**
 * 单体测试应用程序
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 7, 2010 2:13:45 PM
 */
public class SingletonTestApp {

	public static void main(String[] args) {
		//new Test();
		SingletonTest t = SingletonTest.getInstance();
		SingletonTest t2 = SingletonTest.getInstance();
		System.out.println("t == t2 ? " + (t == t2));
		
		//new Singleton();
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s == s2);
	}
}
