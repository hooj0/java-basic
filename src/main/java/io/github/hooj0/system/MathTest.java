package io.github.hooj0.system;

import io.github.hooj0.BasedTests;


/**
 * 数学考试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 15, 2011 10:11:35 PM
 */
public class MathTest extends BasedTests {

	public static void main(String[] args) {
		//将弧度转换为角度
		out("Math.toDegrees(1.57): " + Math.toDegrees(1.57));
		//将角度转换为弧度
		out("Math.toRadians(90): " + Math.toRadians(90));
		//计算反余弦，返回角度范围在0.0到pi之间
		out("Math.acos(0.3): " + Math.acos(0.3));
		//计算反正弦，返回的角度范围在-pi/2到pi/2之间
		out("Math.asin(0.8): " + Math.asin(0.8));
		//计算反正切，返回的角度范围在-pi/2到pi/2之间
		out("Math.atin(2.3): " + Math.atan(2.3));
		
		//计算三角余弦
		out("Math.cos(2.3):" + Math.cos(2.3));
		//计算双曲线余弦
		out("Math.cosh(1.2): " + Math.cosh(1.2));
		//计算正弦
		out("Math.sin(1.57): " + Math.sin(1.57));
		//计算双曲线正弦
		out("Math.sinh(1.2): " + Math.sinh(1.2));
		//计算三角正切
		out("Math.tan(0.8): " + Math.tan(0.8));
		//计算双角余弦
		out("Math.tanh(2.1): " + Math.tanh(2.1));
		
		//将矩形坐标(x, y)转换成极坐标(r, thet), 返回所得角theta
		out("Math.atan2(0.1, 0.2): " + Math.atan2(0.1, 0.2));
		
		//取整，返回小于目标数的最小整数
		out("Math.floor(-1.2): " + Math.floor(-1.2));
		//取整，返回大于目标数的最大整数
		out("Math.cell(1.2): " + Math.ceil(1.2));
		
		//四舍五入
		out("Math.round(2.3): " + Math.round(2.3));
		
		//计算平方根
		out("Math.sqrt(2.3): " + Math.sqrt(2.3));
		//计算立方根
		out("Math.cbrt(9): " + Math.cbrt(9));
		//返回欧拉数e的n次幂
		out("Math.exp(2): " + Math.exp(2));
		//返回Math.hypot(4, 4)没有中间溢出或下溢
		out("Math.hypot(4, 4): " + Math.hypot(4, 4));
		//按照IEEE 754标准规定，对两个参数进行余弦运算
		out("Math.IEEEremainder(5, 2): " + Math.IEEEremainder(5, 2));
		
		//计算乘方
		out("Math.pow(3, 2): " + Math.pow(3, 2));
		//计算自然对数
		out("Math.log(1.2): " + Math.log(1.2));
		//计算底数为10的对数
		out("Math.log10(9): " + Math.log10(9));
		//回参数与1之间的自然对数
		out("Math.log1p(9): " + Math.log1p(9));
		
		//计算绝对值
		out("Math.abs(-4.5): " + Math.abs(-4.5));
		//符号赋值，返回第二个符号的第一个浮点参数
		out("Math.copySign(1.2, -1.0): " + Math.copySign(1.2, -1.0));
		//符号函数，如果参数为0，则返回0，如果参数大于0.则返回1.0；如果参数小于0，返回-1.0
		out("Math.signum(2.3): " + Math.signum(2.3));
		
		//找出最大值
		out("Math.max(2.3, 2.4): " + Math.max(2.3, 2.4));
		//找出最小值
		out("Math.min(1.2, 3.4): " + Math.min(1.2, 3.4));
		//返回第一个参数和第二个参数之间与第一个参数相邻的浮点数
		out("Math.nextAfter(1.2, 1.0): " + Math.nextAfter(1.2, 1.0));
		//返回比目标数略大的数
		out("Math.nextUp(1.2): " + Math.nextUp(1.2));
		//返回一个伪随机数，该值大于等于0.0且小于1.0
		out("Math.random(): " + Math.random());
	}
}
