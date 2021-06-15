package io.github.hooj0.classloader.instance;

public class SingletonTest {
	private SingletonTest(){
		System.out.println("私有无参构造，其他类不能实例化 Me！");
	}
	
	{
		System.out.println("普通初始化块，execute……");
	}
	private static SingletonTest t;
	static {
		t = new SingletonTest();
		System.out.println("静态初始化块，只运行一次");
	}
	
	public static SingletonTest getInstance() {
		return t;
	}
	
	public static void main(String[] args) {
		System.out.println("#########1#########");
		SingletonTest t = new SingletonTest();
		System.out.println("#########2#########");
		SingletonTest t2 = new SingletonTest();
		System.out.println(t == t2);
		System.out.println("#########3#########");
		SingletonTest t3 = SingletonTest.getInstance();//执行一次，只有一个实例
		System.out.println(t3 == t2);
		System.out.println("#########4#########");
		SingletonTest t4 = SingletonTest.getInstance();
		System.out.println(t3 == t4);//指向同一个对象
	}
}
