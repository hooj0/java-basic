package io.github.hooj0.collection.base;

import java.util.Stack;

public class StackTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 9, 2011 10:49:10 PM
	 * @param args
	 */
	public static void main(String[] args) {
		//Stack继承了Vector
		Stack<String> stack = new Stack<String>();
		stack.add("Java");
		stack.add("Struts");
		stack.add("ORM");
		
		System.out.println(stack);
		//第一个元素，并不pop出栈
		System.out.println(stack.peek());
		System.out.println(stack);
		
		System.out.println(stack.pop());//出栈
		System.out.println(stack);
	}
	/**
	 * ArrayList和Vector的区别：
	 * ArrayList是线程不安全的，当多条线程访问同一个ArrayList集合时，
	 * 如果有超过一条线程修改了ArrayList集合，则程序必须手动保证该集合的
	 * 同步性。但Vector则是线程安全的，无需保证程序的同步性。因为Vector是线程
	 * 安全的，所以Vector的性能比ArrayList的性能要低。要保证List集合的线程安全，
	 * 同样不推荐使用Vector的实现类
	 */
}
