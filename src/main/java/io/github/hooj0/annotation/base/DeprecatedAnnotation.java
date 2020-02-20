package io.github.hooj0.annotation.base;

/**
 * 弃用注释
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 28, 2010 10:10:00 PM
 */
@SuppressWarnings("ALL")
public class DeprecatedAnnotation {
	
	@Deprecated
	public void doSomething() {
		System.out.println("this is doSomething!");
	}
	
	/*
	 * @Deprecated表示此方法过时，不推荐使用
	 * 如果一个项目中用到某个方法，但是在后期对项目有了很大的扩展。并且这个方法也被其他方法所取代
	 * 因为被取代的方法又被广泛使用，所以不能删除这个方法。
	 * 那么你就可以用这个注解@Deprecated，告诉后面使用这个方法的人。这个方法已经过时了，不推荐使用
	 * 已经有更好的方法取代这个方法
	 */
	public void doSomething(String string) {
		System.out.println(string + "this is doSomething!");
	}
	
	public static void main(String[] args) {
		DeprecatedAnnotation da = new DeprecatedAnnotation();
		da.doSomething();
		da.doSomething("Hello ");
	}
}
