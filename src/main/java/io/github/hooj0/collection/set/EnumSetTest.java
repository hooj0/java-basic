package io.github.hooj0.collection.set;

import io.github.hooj0.collection.base.Season;

import java.util.EnumSet;

public class EnumSetTest {

	/**
	 * 
	 * @author hoojo
	 * @createDate Jan 9, 2011 6:22:01 PM
	 * @param args
	 */
	public static void main(String[] args) {
		EnumSet<Season> e = EnumSet.allOf(Season.class);
		System.out.println(e);
		EnumSet<Season> e2 = EnumSet.noneOf(Season.class);
		System.out.println(e2);
		
		e2.add(Season.WINTER);
		e2.add(Season.SPRING);
		System.out.println(e2);
		
		EnumSet<Season> e3 = EnumSet.of(Season.SUMMER, Season.WINTER);
		System.out.println(e3);
		EnumSet<Season> e4 = EnumSet.range(Season.SUMMER, Season.WINTER);
		System.out.println(e4);
		
		EnumSet<Season> e5 = EnumSet.complementOf(e4);
		System.out.println(e5);
	}
}