package io.github.hooj0.generic.boxing;

/**
 * 操作
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:16:20
 */
public class Operation {

	public static void main(String[] args) {
		Integer a = 100;//在-127~128范围，相当于int
		Integer b = 100;
		if (a == b) {
			System.out.println("a == b");
		} else {
			System.out.println("a != b");
		}
		
		Integer one = 150;//大于128，相当于new Integer
		Integer two = 150;
		if (one == two) {
			System.out.println("one == two");
		} else {
			System.out.println("one != two");
		}
		
		/**
		 * a == b
		 * one != two
		 * ??? 原因是：在装箱和拆箱中，Integer的值在-127——128就比较值（相当于int比较）
		 * 当超出这个范围就比较内存地址，也就是对象间的比较
		 */
	}
}
