package io.github.hooj0.classloader.classInit;

/**
 * 类init test5
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:14:40
 */
public class ClassInitTest5 {
	public static void main(String[] args) {
		System.out.println(Temp.timed);
		/**
		 * 由于timed的值只能在运行的时候得到，编译的时候无法获取值
		 * 所以通过类访问静态属性的时候，会导致该类初始化。从而static运行了
		 */
	}
}

class Temp {
	static {
		System.out.println("运行……");
	}
	static long timed = System.currentTimeMillis();
}
