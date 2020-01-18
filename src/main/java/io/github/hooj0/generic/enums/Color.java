package io.github.hooj0.generic.enums;

/**
 * 颜色
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/07 17:18:18
 */
public enum Color {
	RED, WHITE, BLUE, YELLOW;//在枚举中，多个属性接受后。如果还有内容就需要用；号分隔
	
	public static void main(String[] args) {
		System.out.println(Color.BLUE);
		System.out.println(Color.RED);
		
		for (Color c : Color.values()) {
			System.out.println(c);
		}
	}
}
