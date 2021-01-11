package io.github.hooj0.classloader.classInit;

class Test4 {
	
	static {
		System.out.println("静态初始化块……");
	}
	
	final static String temp = "这个是常量";
}

public class Test3 {
	public static void main(String[] args) {
		/**
		 * 系统首次使用某个类的和接口的时候，系统就会初始化该类和接口
		 * 1、创建类的实例，new操作创建实例，通过反射创建实例，通过反序列化创建实例
		 * 2、调用某个类的静态方法
		 * 3、访问某个类的静态属性和接口，或为该静态属性赋值
		 * 4、使用反射方式强制创建某个类和接口对应的java.lang.Class对象。
		 * eg：Class.forName("com.hoo.dao.BaseDao")
		 * 如果系统还未初始化BaseDao类，则这行代码将会初始化BaseDao
		 * 并返回BaseDao对应的java.lang.Class对象。
		 * 5、初始化某个类的子类，当初始化某个类的子类时，该子类的所有父类都会被初始化
		 * 6、直接用java.exe来运行某个主类，当运行某个主类时，程序会先初始化该主类
		 * 注意：对fanal的静态属性，如果该属性可以在编译期间得到值，则可以认为该属性可以被当做
		 * 编译的常量。当程序使用编译的常量时，系统会认为该类被动使用，所以不会导致该类初始化。
		 */
		//访问常量temp，静态块没有执行;因为编译期间就可以得到值，故该类无需初始化
		System.out.println(Test4.temp);
	}
}
