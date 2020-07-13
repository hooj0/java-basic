package io.github.hooj0.generic.source;

/**
 * 测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:27:26
 */
public class Test {
	public static void main(String[] args) {
		StringCase foo1 = new StringCase();
		foo1.setFoo("hello world");
		String name = foo1.getFoo();
		System.out.println(name);
		
		IntegerCase foo2 = new IntegerCase();
		foo2.setFoo(new Integer(100));
		Integer age = foo2.getFoo();
		System.out.println(age);
		
		/**
		 * 类别定义时的逻辑完全一样，只是里面成员变量的类型不同
		 * 如果需要多个相似的类，需要定义多个文件，不同的只是变量的类别，而逻辑是完全一样的
		 * 在jdk 1.4可以用Object然后向下类型转换，1.5就可以用泛型
		 */
		
		ObjectCase foo3 = new ObjectCase();
		foo3.setFoo(new String("abc"));
		String a = (String) foo3.getFoo();
		System.out.println(a);
		
		ObjectCase foo4 = new ObjectCase();
		foo4.setFoo(new Integer(1));
		Integer b = (Integer) foo4.getFoo();
		System.out.println(b);
		
		
		/*
		 *不清楚类型的情况下，容易出现类型转换错误
		 *如果用泛型就不会有这种情况了
		 */ 
		//String c = (String) foo4.getFoo();
		//System.out.println(c);
	}
}
