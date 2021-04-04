package io.github.hooj0.system;

public class StringBuilderTest {

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Jan 15, 2011 10:06:03 PM
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("java");
		System.out.println(sb);
		sb.insert(0, "easy ");
		System.out.println(sb);
		sb.replace(4, 5, ",");
		System.out.println(sb);
		
		sb.delete(4, 5);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.length());
		sb.setLength(4);
		System.out.println(sb);
	}
}
