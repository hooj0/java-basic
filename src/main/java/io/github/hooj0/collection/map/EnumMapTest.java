package io.github.hooj0.collection.map;

import io.github.hooj0.BasedTests;
import io.github.hooj0.collection.base.Season;

import java.util.EnumMap;


/**
 * enum测验
 *
 * @author hoojo
 * @version 1.0
 * @date Jan 13, 2011 10:53:09 PM
 */
public class EnumMapTest extends BasedTests {

	/**
	 * key只能为枚举类型
	 */
	public static void main(String[] args) {
		EnumMap<Season, String> enumMap = new EnumMap<Season, String>(Season.class);
		enumMap.put(Season.SPRING, "春暖花开");
		enumMap.put(Season.SUMMER, "挥汗如雨");
		
		out(enumMap);
	}
}
