package io.github.hooj0.classloader.instance;

public class Test2 {
	/**
	 * <b>function:</b>单例
	 * @author hoojo
	 * @createDate Oct 7, 2010 2:13:45 PM
	 * @param args
	 */
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
