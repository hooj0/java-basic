package io.github.hooj0.classloader.q1;

public class TestB {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Sep 27, 2010 10:11:23 PM
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ClassA b = new ClassA();
		System.out.println(b.a);//10
		/**
		 * 不受TestA的影响，所以结果还是10 
		 * 因为TestA、TestB运行是2次不同的进程，2次jvm的运行
		 * 2个不同的进程（JVM）静态属性的数据不存在共享
		 */
	}

}
