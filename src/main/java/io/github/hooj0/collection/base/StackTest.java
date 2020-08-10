package io.github.hooj0.collection.base;

import io.github.hooj0.BasedTests;

import java.util.Stack;

/**
 * 堆栈测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 9, 2011 10:49:10 PM
 */
public class StackTest extends BasedTests {

	public static void main(String[] args) {
		//Stack继承了Vector
		Stack<String> stack = new Stack<String>();
		stack.add("Java");
		stack.add("Struts");
		stack.add("ORM");
		
		out(stack);
		//第一个元素，并不pop出栈
		out(stack.peek());
		out(stack);
		
		out(stack.pop());//出栈
		out(stack);
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
