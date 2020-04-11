package io.github.hooj0.generic.generictype;

/**
 * 泛型转换
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:22:31
 */
public class GenericCase<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		GenericCase<String> foo1 = new GenericCase<String>();
		foo1.setT(new String("abc"));
		String name = foo1.getT();
		System.out.println(name);
		
		GenericCase<Integer> foo2 = new GenericCase<Integer>();
		foo2.setT(new Integer(22));
		Integer age = foo2.getT();
		System.out.println(age);
		//编译不通过，已知类型Integer，不能赋值String
		//foo2.setT("abc");
	}
}
