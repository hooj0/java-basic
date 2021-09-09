package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

import java.math.BigDecimal;

/**
 * 大十进制测试
 *
 * @author hoojo
 * @version 1.0
 * @date Feb 13, 2011 9:14:40 PM
 */
public class BigDecimalTest extends BasedTests {

	public static void main(String[] args) {
		out("0.05 + 0.01 = " + (0.05 + 0.01));
		out("1.0 - 0.42 = " + (1.0 - 0.42));
		out("4.015 * 100 = " + (4.015 * 100));
		out("123.3 / 100 = " + (123.3 / 100));
		
		BigDecimal f1 = new BigDecimal("0.05");
		BigDecimal f2 = BigDecimal.valueOf(0.01D);
		BigDecimal f3 = new BigDecimal(0.05D);
		out("下面使用String作为BigDecimal构造器参数的计算结果： ");
		out("0.05 + 0.01 = " + f1.add(f2));
		out("0.05 - 0.01 = " + f1.subtract(f2));
		out("0.05 * 0.01 = " + f1.multiply(f2));
		out("0.05 / 0.01 = " + f1.divide(f2));
		
		out("下面使用Double作为BigDecimal构造器参数的计算结果： ");
		out("0.05 + 0.01 = " + f3.add(f2));
		out("0.05 - 0.01 = " + f3.subtract(f2));
		out("0.05 * 0.01 = " + f3.multiply(f2));
		out("0.05 / 0.01 = " + f3.divide(f2));
	}
}
