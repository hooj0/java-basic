package io.github.hooj0.system;

import java.math.BigDecimal;

public class ArithUtils {
	
	//默认触发运算精度
	private static final int DEFAULT_SCALE = 10;
	//私有构造函数
	private ArithUtils() {
	}
	
	/**
	 * <b>function:</b>精确的计算2个数的和
	 * @author hoojo
	 * @createDate Feb 13, 2011 10:46:39 PM
	 * @param v1 加数
	 * @param v2 被加数
	 * @return 2数之和
	 */
	public static double add(double v1, double v2) {
		return BigDecimal.valueOf(v1).add(BigDecimal.valueOf(v2)).doubleValue();
	}
	
	/**
	 * <b>function:</b>精确计算2个数之差
	 * @author hoojo
	 * @createDate Feb 13, 2011 10:51:26 PM
	 * @param v1 减数
	 * @param v2 被减数
	 * @return 2数的差
	 */
	public static double sub(double v1, double v2) {
		return BigDecimal.valueOf(v1).subtract(BigDecimal.valueOf(v2)).doubleValue();
	}
	
	/**
	 * <b>function:</b>提供2个数的乘法运算
	 * @author hoojo
	 * @createDate Feb 13, 2011 10:53:39 PM
	 * @param v1 乘数
	 * @param v2 被乘数
	 * @return 2数之积
	 */
	public static double mul(double v1, double v2) {
		return BigDecimal.valueOf(v1).multiply(BigDecimal.valueOf(v2)).doubleValue();
	}
	
	/**
	 * <b>function:</b>提供相对精确的除法运算，当发生除不尽的情况时，精确到小数点以后10位的数字四舍五入
	 * @author hoojo
	 * @createDate Feb 13, 2011 10:55:37 PM
	 * @param v1 除数
	 * @param v2 被除数
	 * @return 2数之商
	 */
	public static double div(double v1, double v2) {
		return BigDecimal.valueOf(v1).divide(
				BigDecimal.valueOf(v2),
				DEFAULT_SCALE, 
				BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Feb 13, 2011 9:26:29 PM
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("0.05 + 0.01 = " + ArithUtils.add(0.05, 0.01));
		System.out.println("1.0 - 0.42 = " + ArithUtils.sub(1.0, 0.42));
		System.out.println("4.015 * 100 = " + ArithUtils.mul(4.015, 100));
		System.out.println("123.3 / 100 = " + ArithUtils.div(123.3, 100));
	}
}
