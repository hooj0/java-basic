package io.github.hooj0.generic.enums;

public class EnumTest {
	
	public static void operation(Tank t) {
		switch (t) {
			case TURN_LEFT: 
				System.out.println("向左转");
				break;
			case TURN_RIGHT:
				System.out.println("向右转");
				break;
			case TREAD:
				System.out.println("行走");
				break;
			case FIRE: 
				System.out.println("开火");
				break;
		}
	}
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Oct 7, 2010 12:11:11 PM
	 * @param args
	 */
	public static void main(String[] args) {
		operation(Tank.FIRE);
	}
}

enum Tank {
	TURN_LEFT, TURN_RIGHT, FIRE, TREAD;//;号可要可不要
}