package io.github.hooj0.exception;

/**
 * 捕获异常测试
 *
 * @author hoojo
 * @version 1.0
 * @date Mar 3, 2011 10:06:48 PM
 */
public class CatchDivTest {

	public static void main(String[] args) {
		try {
			int a = Integer.parseInt("22");
			int b = Integer.parseInt("0");
			int c = a / b;
			System.out.println("请输出两个数相除的结果：" + c);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("数组越界：运行程序时输入的参数个数不够");
		} catch (NumberFormatException e) {
			System.out.println("数字格式异常：程序只能接受正整数");
		} catch (ArithmeticException e) {
			System.out.println("算术异常" + e.getLocalizedMessage());
		} catch(Exception e) {
			System.out.println("未知异常" + e.getMessage());
		}
	}
}
