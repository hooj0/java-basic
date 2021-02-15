package io.github.hooj0.classloader.q1;

public class TestA {
	
	/**
	 *
	 * @author hoojo
	 * @createDate Sep 27, 2010 10:04:36 PM
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ClassA a = new ClassA();
		//让a中静态属性a自加
		a.a++;
		System.out.println(a.a);//print 11
		
		ClassA b = new ClassA();
		System.out.println(b.a);//11,a，b是同一个类，同一个jvm调用静态属性，内存共享。	
		/**
		 * 2个实例，在同一次jvm运行中调用静态属性a
		 * 同一个类的所有实例的静态属性共享同一块内存。
		 */
	}

}
