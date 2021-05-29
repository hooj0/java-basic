package io.github.hooj0.system;

import io.github.hooj0.BasedTests;

/**
 * 字符串构建器测试
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 15, 2011 10:06:03 PM
 */
public class StringBuilderTest extends BasedTests {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("java");
		out(sb);
		sb.insert(0, "easy ");
		out(sb);
		sb.replace(4, 5, ",");
		out(sb);
		
		sb.delete(4, 5);
		out(sb);
		
		sb.reverse();
		out(sb);
		out(sb.length());
		sb.setLength(4);
		out(sb);
	}
}
