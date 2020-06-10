package io.github.hooj0.classloader.classInit;

/**
 * 类init test2
 *
 * @author hoojo
 * @version 1.0
 * @date Sep 27, 2010 11:29:52 PM
 */
@SuppressWarnings("ALL")
public class ClassInitTest2 extends ClassB {

	private ClassInitTest2() {
		System.out.println("init TestInit");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClassB b = new ClassInitTest2();
		ClassA a = new ClassInitTest2();
		//TestInit t = new TestInit();
		/**
		 * 先初始化父类，再是子类；
		 * 先执行父类的所有静态块，然后是子类的静态块。(静态块在一次JVM中只会运行一次)
		 * 然后是父类的构造，再是子类的构造
		 */
	}
}
