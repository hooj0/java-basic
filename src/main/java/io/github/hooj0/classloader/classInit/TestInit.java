package io.github.hooj0.classloader.classInit;

@SuppressWarnings("ALL")
public class TestInit extends ClassB {

	private TestInit() {
		System.out.println("init TestInit");
	}

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Sep 27, 2010 11:29:52 PM
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClassB b = new TestInit();
		ClassA a = new TestInit();
		//TestInit t = new TestInit();
		/**
		 * 先初始化父类，再是子类；
		 * 先执行父类的所有静态块，然后是子类的静态块。(静态块在一次JVM中只会运行一次)
		 * 然后是父类的构造，再是子类的构造
		 */
	}
}
