package io.github.hooj0.system;

import java.math.BigDecimal;

public class BigDecimalTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Feb 13, 2011 9:14:40 PM
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("0.05 + 0.01 = " + (0.05 + 0.01));
		System.out.println("1.0 - 0.42 = " + (1.0 - 0.42));
		System.out.println("4.015 * 100 = " + (4.015 * 100));
		System.out.println("123.3 / 100 = " + (123.3 / 100));
		
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01);
		BigDecimal f3 = new BigDecimal(0.05);
		System.out.println("下面使用String作为BigDecimal构造器参数的计算结果： ");
		System.out.println("0.05 + 0.01 = " + f1.add(f2));
		System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f1.divide(f2));
		
		System.out.println("下面使用Double作为BigDecimal构造器参数的计算结果： ");
		System.out.println("0.05 + 0.01 = " + f3.add(f2));
		System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
		System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
		System.out.println("0.05 / 0.01 = " + f3.divide(f2));
	}
}
